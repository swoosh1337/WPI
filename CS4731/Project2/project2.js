// Irakli Grigolia Homework2


// necessary variables
var pBuffer , cBuffer ,points, newPoints, colors,  gl ,program, iD;
var centerX = 0;
var centerY = 0;
var centerZ = 0;
var renderTime = 0;
var theta = 0;
var xtheta = 0;
var ytheta = 0;
var ztheta = 0;
var scale = 1;
var xtrans = [false, false, 0];
var ytrans = [false, false, 0];
var ztrans = [false, false, 0];
var rollx = false;
var rolly = false;
var rollz = false;
var pulsing = false;


document.getElementById('file_select').addEventListener('change', handleFileSelect, false);
//function handles keys
window.onkeydown = function(event){
	if(event.keyCode !== 0){
		var key = String.fromCharCode(event.keyCode);
		switch(key)
		{
			case 'U':
				ytrans[1] = !ytrans[1];
				ytrans[0] = false;
				break;
			case 'Z':
				ztrans[0] = !ztrans[0];
				ztrans[1] = false;
				break;
			case 'A':
				ztrans[1] = !ztrans[1];
				ztrans[0] = false;
				break;
			case 'R':
				rollx = !rollx;
				break;
			case 'V':
				rollz = !rollz;
				break;
			case 'B':
				pulsing = !pulsing;
				break;
			case 'X':
				xtrans[0] = !xtrans[0];
				xtrans[1] = false;
				break;
			case 'C':
				xtrans[1] = !xtrans[1];
				xtrans[0] = false;
				break;
			case 'Y':
				ytrans[0] = !ytrans[0];
				ytrans[1] = false;
				break;

		}
	}
};


// main function
function main()
{
	// getting canvas element
	var canvas = document.getElementById('webgl');
	gl = WebGLUtils.setupWebGL(canvas, undefined);
	if (!gl){
		console.log('Failed to get the rendering context for WebGL');
		return;
	}
	//initializing shaders
	program = initShaders(gl, "vshader", "fshader");
	gl.useProgram(program);
	gl.viewport( 0, 0, 400, 400);
	gl.clearColor(1.0, 1.0, 1.0, 1.0);
	gl.enable(gl.DEPTH_TEST);

	colors = [];
	points = [];
	newPoints = [];


	pBuffer = gl.createBuffer();
	gl.bindBuffer(gl.ARRAY_BUFFER, pBuffer);
	gl.bufferData(gl.ARRAY_BUFFER, flatten(points), gl.STATIC_DRAW);

	var vPosition = gl.getAttribLocation(program,  "vPosition");
	gl.vertexAttribPointer(vPosition, 4, gl.FLOAT, false, 0, 0);
	gl.enableVertexAttribArray(vPosition);

	cBuffer = gl.createBuffer();
	gl.bindBuffer(gl.ARRAY_BUFFER, cBuffer);
	gl.bufferData(gl.ARRAY_BUFFER, flatten(colors), gl.STATIC_DRAW);

	var vColor= gl.getAttribLocation(program,  "vColor");
	gl.vertexAttribPointer(vColor, 4, gl.FLOAT, false, 0, 0);
	gl.enableVertexAttribArray(vColor);

	var proj = ortho(-1, 1, -1, 1, -1, 1);
	var projMatrix = gl.getUniformLocation(program, 'projectionMatrix');
	gl.uniformMatrix4fv(projMatrix, false, flatten(proj));
	render(1);
}



//function for rendering
function render(time)
{

	var drawingtime = renderTime-time;
	renderTime = time;

	var translateMatrix = mat4(
		1, 0, 0, -centerX,
		0, 1, 0, -centerY,
		0, 0, 1, -centerZ,
		0, 0, 0, 1
	);
	var scaleMatrix = mat4(
		1/scale, 0, 0, 0,
		0, 1/scale, 0, 0,
		0, 0, 1/scale, 0,
		0, 0, 0, 1
	);

	var rxMatrix = rotateX(xtheta);
	var ryMatrix = rotateY(ytheta);
	var rzMatrix = rotateZ(ztheta);
	var ctMatrix = mult(rxMatrix, ryMatrix);
	ctMatrix = mult(ctMatrix, rzMatrix);
	if(rollx)
		xtheta+= .05 * drawingtime;
	if(rolly)
		ytheta+= .05 * drawingtime;
	if(rollz)
		ztheta+= .05 * drawingtime;

	// animation speed calculations
	var speed = drawingtime * 0.0015;
	xtrans[2] += speed * xtrans[1] - speed * xtrans[0];
	var transMatrix = translate(xtrans[2], ytrans[2], ztrans[2]);
	newPoints = [];
	pulseFaces(drawingtime);
	var at = vec3(0,0,0);
	ytrans[2] += speed*ytrans[1] - speed * ytrans[0];
	var aspectRatio = 1;
	ztrans[2] += speed*ztrans[0] - speed * ztrans[1];
	var up = vec3(0,1,0);
	var eye = vec3(0, 0, 2);
	var modelView = lookAt(eye, at, up);
	var moved = mult(modelView, transMatrix);
	var rotated = mult(moved, ctMatrix);
	var fovY = 45;
	var proj = perspective(fovY, aspectRatio, 0.01, 100);
	var scaled = mult(rotated, scaleMatrix);
	var final = mult(scaled, translateMatrix);
	gl.clear( gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);
	var projMatrix = gl.getUniformLocation(program, 'projectionMatrix');
	gl.uniformMatrix4fv(projMatrix, false, flatten(proj));

	var modelMatrix = gl.getUniformLocation(program, 'modelMatrix');
	gl.uniformMatrix4fv(modelMatrix, false, flatten(final));

	//pushing each vertex position
	gl.bindBuffer(gl.ARRAY_BUFFER, pBuffer);
	gl.bufferData(gl.ARRAY_BUFFER, flatten(newPoints), gl.STATIC_DRAW);
	//For each vertex, push color data.
	gl.bindBuffer(gl.ARRAY_BUFFER, cBuffer);
	gl.bufferData(gl.ARRAY_BUFFER, flatten(colors), gl.STATIC_DRAW);

	for(var i = 0; i < points.length-2; i += 3)
		gl.drawArrays(gl.LINE_LOOP, i, 3);

	iD = requestAnimationFrame(render);
}




// function for Newell Method
function newellMethood(a){
	var x = 0;
	var y = 0;
	var z = 0;
	a.push(a[0]);
	for(var i = 0; i < a.length-1; i++){
		x += (a[i][1] - a[i+1][1]) * (a[i][2] + a[i+1][2]);
		y += (a[i][2] - a[i+1][2]) * (a[i][0] + a[i+1][0]);
		z += (a[i][0] - a[i+1][0]) * (a[i][1] + a[i+1][1]);
	}
	 normal = vec3(x,y,z);
	return normal;
}


// function for pulsing
function pulseFaces(drawingtime){
	if(pulsing){
		theta = theta+(drawingtime/1000)
	}
	let multVec = (Math.cos(theta) - 1);
	multVec = -multVec * scale/100;
	for(var tri = 0; tri < points.length-2; tri += 3){

		array = [];
		array.push(points[tri]);
		array.push(points[tri+1]);
		array.push(points[tri+2]);
		//using newwell method
		var normal = newellMethood(array);
		normal = normalize(normal);

		scaledNormal = vec3(normal[0]*multVec ,normal[1]*multVec ,normal[2]*multVec);
		tMat = translate(scaledNormal);
		for(var i = tri; i < tri+3; i++){
			movedPoint = mult(tMat, vec4(points[i][0],points[i][1],points[i][2],1));
			newPoints.push(movedPoint)
		}
	}
	normals = true
}

// fucntion for file upload 
document.getElementById('select_file').reset();
function handleFileSelect(event) {

	var file = event.target.files[0];
	//checking file if empty
	if (file){
		var firstbound = [Number.POSITIVE_INFINITY, Number.NEGATIVE_INFINITY];
		var secondbounds = [Number.POSITIVE_INFINITY, Number.NEGATIVE_INFINITY];
		var thirdbound = [Number.POSITIVE_INFINITY, Number.NEGATIVE_INFINITY];
		normals = false;

		var vList = [];
		var vNum = -1;
		var pList = [];
		var pNum = -1;

		//creating the reader, reading the file, and then sending the result to the parser function. like we did in project1
		var reader = new FileReader();
		reader.readAsText(file);
		reader.onload = function(){
			var split = reader.result.split("\n");
			var headerFinished = false;

			for(var i = 0; i < split.length; i++){
				a = split[i].match(/\S+/g);
				if(!a){continue;}
				if(!headerFinished){
					if(i === 0){
						if (a[0] !== "ply") {
							alert("Error: File could not be read");
							return;
						} else {

						}
					} else if (a[0] === "element"){
						if(a[1] === "vertex")
							vNum = parseFloat(a[2]);
						if(a[1] === "face")
							pNum = parseFloat(a[2]);
					} else if (a[0] === "end_header"){
						headerFinished = true;
					}
				} else{
					for(var c = 0; c < vNum; c++){
						a = split[i].match(/\S+/g);
						var x = parseFloat(a[0]);
						var y = parseFloat(a[1]);
						var z = parseFloat(a[2]);
						vList.push(vec4(x, y, z, 1.0));
						if(x < firstbound[0])
							firstbound[0] = x;
						if(x > firstbound[1])
							firstbound[1] = x;
						if(y < secondbounds[0])
							secondbounds[0] = y;
						if(y > secondbounds[1])
							secondbounds[1] = y;
						if(z < thirdbound[0])
							thirdbound[0] = z;
						if(z > thirdbound[1])
							thirdbound[1] = z;
						i++
					}

					for(var t = 0; t < pNum; t++){
						l = split[i].match(/\S+/g);
						pList.push(vec3(parseInt(l[1]), parseInt(l[2]), parseInt(l[3])));
						i++
					}

				}
			}
			var scaleX = (firstbound[1] - firstbound[0]);
			var scaleY = (secondbounds[1] - secondbounds[0]);
			var scaleZ = (thirdbound[1] - thirdbound[0]);
			scale = Math.max(scaleX, scaleY, scaleZ);
			centerX = 0.5*(firstbound[0]+firstbound[1]);
			centerY = 0.5*(secondbounds[0]+secondbounds[1]);
			centerZ = 0.5*(thirdbound[0]+thirdbound[1]);

			points = [];
			colors = [];
			var a = vec4(0.0, 0.0, 0.0, 1.0);
			for(i in pList){
				points.push(vList[pList[i][0]]);
				points.push(vList[pList[i][1]]);
				points.push(vList[pList[i][2]]);
				colors.push(a);
				colors.push(a);
				colors.push(a);
			}
			xtrans[2] = 0;
			ytrans[2] = 0;
			ztrans[2] = 0;
			xtheta = 0;
			ytheta = 0;
			ztheta = 0;
		}
	}
}
