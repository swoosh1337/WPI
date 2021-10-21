
// necessary variables
var points, gl, program, mvMatrix, pMatrix, modelView, projection,cube,id,gourandNormal2;
let spiko, normalsArray1 ,normalsArray2, gourandNormal,ratio;
let gouraudShading = true;
let animation = true;
let stack = [];
let alpha, theta, omega;
alpha = omega = theta = 0;
let materialShininess = 35.0;
let light_limit = 1;

function main(){

    var canvas = document.getElementById('webgl');
    gl = WebGLUtils.setupWebGL(canvas, undefined);
    if (!gl)
    {
        console.log('Failed to get the rendering context for WebGL');
        return;
    }

    // Initializing shaders
    program = initShaders(gl, "vshader", "fshader");
    gl.useProgram(program);
    gl.viewport( 0, 0, canvas.width, canvas.height);
    ratio = canvas.width/canvas.height;
    gl.clearColor(0.0, 0.0, 0.0, 1.0);
    gl.enable(gl.DEPTH_TEST);

    gl.uniform4fv(gl.getUniformLocation(program, "lightPosition"), flatten(lightPosition));
    gl.uniform1f(gl.getUniformLocation(program, "shininess"), materialShininess);

    points = [];
    spiko = [];
    normalsArray1 = [];
    normalsArray2 = [];
    gourandNormal = [];
    gourandNormal2 = [];

    //sphere making
    sphere(va, vb, vc, vd, num);

    //calcualting normals
    normalsArray = calcualte_normal(spiko);

    //making cube
    cube = cube();
    normalsArray2 = calcualte_normal(cube);
    let vertex = [];
    for(let i = 0; i < cube.length; i++){
        vertex = cube[i];
        gourandNormal2.push(vertex[0], vertex[1], vertex[2], 0.0);
    }

    projection = gl.getUniformLocation(program, "projectionMatrix");
    modelView = gl.getUniformLocation(program, "modelMatrix");
    gl.clear( gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);

    pMatrix = perspective(50, ratio, .1, 70);
    gl.uniformMatrix4fv( projection, false, flatten(pMatrix) );


    let at = vec3(0, 0, 0);
    let up = vec3(0, 1, 0);
    let eye = vec3(0, 0, 20);
    mvMatrix = lookAt(eye, at , up);
    render();
}



function calcualte_normal(vertices){

    let arr = [];
    let mx = 0, my = 0, mz = 0;
    let x1, x2, y1, y2,z1,z2,ver;
    let magnitude, normal;

    for(let k = 0; k < vertices.length; k+=3){

        ver = [];

        ver.push(vertices[k]);
        ver.push(vertices[k+1]);
        ver.push(vertices[k+2]);
        ver.push(vertices[k]);

        mx = 0; my = 0; mz = 0;

        //getting x y z
        for(let i = 0; i < ver.length - 1; i++){
            x1 = ver[i][0]; x2 = ver[i+1][0];
            y1 = ver[i][1]; y2 = ver[i+1][1];
            z1 = ver[i][2]; z2 = ver[i+1][2];

            mx += (y1 - y2) * (z1 + z2);
            my += (z1 - z2) * (x1 + x2);
            mz += (x1 - x2) * (y1 + y2);
        }

        magnitude = Math.sqrt(mx*mx + my*my + mz*mz);
        normal = vec3(mx/magnitude, my/magnitude, mz/magnitude);

        arr.push(normal[0], normal[1], normal[2], 0.0);
        arr.push(normal[0], normal[1], normal[2], 0.0);
        arr.push(normal[0], normal[1], normal[2], 0.0);
    }
    return arr;
}


function positionObject(draw, param1, param2, xPos = 0, yPos = 0, zPos = 0){
    stack.push(mvMatrix);
    mvMatrix = mult(mvMatrix, translate(xPos, yPos, zPos));  //translating  object to position given in parameter
    gl.uniformMatrix4fv( modelView, false, flatten(mvMatrix) );
    draw(param1, param2); //drawing an object
    mvMatrix = stack.pop();
}

// function for rotation
function yAxisRotation(xPos, angle){
    var rotMatrix = mult(translate(-xPos, 0, 0), mult(rotateY(angle), translate(xPos, 0, 0)));
    mvMatrix = mult(mvMatrix, rotMatrix);
}

// function for rendering
function render(){

    // handling keystrokes
    window.onkeypress = function (){
        let event1;
        event1 = event;
        let {key} = event1;
        switch(key){
            case 'p': // increasing spotlight
                if(light_limit < 1.0) {
                    light_limit += 0.003;
                    if(!animation)
                        render();
                }
                break;
            case 'i': // decreasing spotlight
                if(light_limit > 0.8) {
                    light_limit -= 0.003;
                    if(!animation)
                        render();
                }
                break;
            case "m": // goraud shading
                gouraudShading = true;
                if(!animation)
                    render();
                break;
            case 'n': // flat shading
                gouraudShading = false;
                if(!animation)
                    render();
                break;
        }
    };



    gl.clear( gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);
    gl.uniform1f(gl.getUniformLocation(program, "cutoff"), light_limit);
    var flag = gl.getUniformLocation(program, "flag");
    gl.uniform1f(flag, 0.0);


    stack.push(mvMatrix);
    mvMatrix = mult(mvMatrix, rotateY(theta));
    positionObject(Sphere, spiko, vec4(0.0, 0.0, 1.0, 1.0), 0, 5); //blue sphere
    positionObject(drawLine, "h", 8, 0, 2.5);
    positionObject(drawLine, "v", 2.5, 0, 3.75);
    positionObject(drawLine, "v", 2.5, -4, 1.25);
    positionObject(drawLine, "v", 2.5, 4, 1.25);
    stack.push(mvMatrix);
    yAxisRotation(4, alpha);
    positionObject(make_cube, cube, vec4(0.0, 1.0, 0.0, 1.0), -4, 0);  // making green cube
    positionObject(drawLine, "h", 4, -4, -2.5);
    positionObject(drawLine, "v", 2.5, -4, -1.25);
    positionObject(drawLine, "v", 2.5, -6, -3.75);
    positionObject(drawLine, "v", 2.5, -2, -3.75);
    stack.push(mvMatrix);
    yAxisRotation(6, omega);
    positionObject(make_cube, cube, vec4(1.0, 1.0, 0.0, 1.0), -6, -5);  //making yellow cube
    mvMatrix = stack.pop();
    stack.push(mvMatrix);
    yAxisRotation(2, omega);
    positionObject(make_cube, cube, vec4(1.0, 0.0, 0.0, 1.0), -2, -5); //making red cube
    mvMatrix = stack.pop();
    mvMatrix = stack.pop();
    stack.push(mvMatrix);
    yAxisRotation(-4, alpha);
    positionObject(Sphere, spiko, vec4(0.0, 0.7, 1.0, 1.0), 4); //making cyan sphere
    positionObject(drawLine, "h", 4, 4, -2.5);
    positionObject(drawLine, "v", 2.5, 4, -1.25);
    positionObject(drawLine, "v", 2.5, 6, -3.75);
    positionObject(drawLine, "v", 2.5, 2, -3.75);
    stack.push(mvMatrix);
    yAxisRotation(-2, omega);
    positionObject(Sphere, spiko, vec4(1.0, 0.0, 1.0, 1.0), 2, -5);  //making magenta sphere
    mvMatrix = stack.pop();
    stack.push(mvMatrix);
    yAxisRotation(-6, omega);
    positionObject(Sphere, spiko, vec4(0.5, 0.5, 0.5, 1.0), 6, -5); //making grey sphere
    mvMatrix = stack.pop();
    mvMatrix = stack.pop();
    mvMatrix = stack.pop();



    if(animation) {
        theta += 1.0;  //counter clockwise
        alpha -= 6.0;  //clockwise
        omega += 8.0;  //counter clockwise
        id = requestAnimationFrame(render);
    }
    else {
        cancelAnimationFrame(id);
    }




}

