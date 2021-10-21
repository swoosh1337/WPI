// Irakli Grigolia Homework 1

// Extra feature: you are able to upload a file and then draw on it in "draw mode" (though it is not working properlly)



// necessary variables
var gl;
var canvas;
var matrix;
var vPosition, vColor;
var width, height;
var setColor = vec4(0.0, 0.0, 0.0, 1.0);
var drawMode = false;
var newLine = false;
var points_array = [];
var onCavnas = [];
var dimension = [0,640,0,480];
var colorIndex = 0;
var mouse = false;


function main()
{
    //get the canvas element
    canvas = document.getElementById('webgl');
    gl = WebGLUtils.setupWebGL(canvas);

    if(!gl){
        console.log('Failed to obtain rendering context');
        return;
    }

    //making viewport
    gl.viewport(0,0,canvas.width,canvas.height);
    height = canvas.height;
    width = canvas.width;

    var program = initShaders(gl, "vshader", "fshader");
    gl.useProgram(program)

    cbuffer = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, cbuffer);

    vColor = gl.getAttribLocation(program, "vColor");
    gl.vertexAttribPointer(vColor, 4, gl.FLOAT, false, 0, 0);
    gl.enableVertexAttribArray(vColor);

    matrix = gl.getUniformLocation(program, "projMatrix");

    pbuffer = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, pbuffer);

    vPosition = gl.getAttribLocation(program, "vPosition");
    gl.vertexAttribPointer(vPosition, 4, gl.FLOAT, false, 0, 0);
    gl.enableVertexAttribArray(vPosition);


// reseting canvas
function canvasRestart(){
    gl.clear(gl.COLOR_BUFFER_BIT);
    onCavnas = [];
    points_array = [];
    gl.viewport(0,0,640,480);
    var projMatrix = ortho(0, 640, 0, 480, -1.0, 1.0);
    gl.uniformMatrix4fv(matrix, false, flatten(projMatrix));
    dimension = [0,640,0,480];
    document.getElementById('file_select').reset();
    document.getElementById('color_select').reset();
}


    //dealing with keypress
    window.onkeydown = function(event){

        if(event.keyCode !== 0){
            var key = String.fromCharCode(event.keyCode);
            switch(key)
            {
                case 'D': //switch  to Draw mode
                    canvasRestart();
                    drawMode = true;
                    var msg = "Draw Mode";
                    document.getElementById('label').innerHTML = msg;

                    break;

                case 'F': //switch  to File mode
                    canvasRestart();
                    drawMode = false;
                    var msg = "File Mode"
                    document.getElementById('label').innerHTML = msg;
                    break;
                
                case 'C': //changes colors
                    gl.clear(gl.COLOR_BUFFER_BIT);
                    colorIndex++;
                    if(colorIndex >= color_cycle.length)
                        colorIndex = 0;
                    setColor = color_cycle[colorIndex];

                    for(s in onCavnas){
                        draw_polyline(onCavnas[s]);
                    }

                    break;
                //handles pressing B
                case 'B':
                    newLine = true;

                    gl.clear(gl.COLOR_BUFFER_BIT);
                    for(s in onCavnas){
                        draw_polyline(onCavnas[s]);
                    }
                    break;
            }
        }
    }
    // handles  pressing B when we want to create a new line
    window.onkeyup = function(event){
        if(event.keyCode !== 0){
            var k = String.fromCharCode(event.keyCode);
            switch(k){
                case 'B':
                    newLine = false;
                    break;
            }
        }
    }
    //drawing new lines
    canvas.onclick = function(event){
        if(drawMode){
            //clearing  canvas
            gl.clear(gl.COLOR_BUFFER_BIT);
            r = mouseCoordinates(event.clientX, event.clientY)
            var y = r[1];
            var x = r[0];
            
            if(newLine)
                points_array = [];

            var i = onCavnas.indexOf(points_array)

            // limit up to 100 points at the same time
            points_array.push(vec4(x,y,0.0,1.0));
            if(points_array.length > 100)
                points_array.shift();

            if(i !== -1) //replace old polyline
                onCavnas.splice(i, 1, points_array);
            else // add a new one
                onCavnas.push(points_array);

            for(s in onCavnas){
                draw_polyline(onCavnas[s]);
            }
            // draw line if we have more the 1 point
            if(points_array.length > 1)
                draw_polyline(points_array);
        }
        canvas.onmousemove = function(event){
            if(drawMode && mouse){
                if(points_array.length > 0){
                    if(!newLine){
                        gl.clear(gl.COLOR_BUFFER_BIT);
                        r = mouseCoordinates(event.clientX, event.clientY)
                        var y = r[1];
                        var x = r[0];
                        
                        for(s in onCavnas){
                            draw_polyline(onCavnas[s]);
                        }
                        var temp = [];
                        temp.push(points_array[points_array.length-1]);
                        temp.push(vec4(x,y,0.0,1.0));
                        draw_polyline(temp);
                    }
                }
            }
        }
    }

    canvas.onmouseover = function(event){
        mouse = true;
    }

}


    //getting mouse coordinates for drawing the image
function mouseCoordinates(clientX, clientY){

    var rectangle = canvas.getBoundingClientRect();
    var topSpace = rectangle.top;
    var leftSpace = rectangle.left
    var mx = ((clientX-leftSpace) / width);
    var my = ((canvas.height-(clientY-topSpace))/ height);
    //converting dimensions
    mx = (mx*(dimension[1]-dimension[0])+dimension[0]);
    my = (my*(dimension[3]-dimension[2])+dimension[2]);
    rect = [mx, my]
    return rect;
}

document.getElementById('file_select').reset();

function fileSelect(event) {
    var file = event.target.files[0];
    //checking if we have a file
    if (file){
    //read the file  and then send the result to the parser .
        var reader = new FileReader();
        reader.readAsText(file);
        reader.onload = function(){
            draw_file(reader.result)
        }
    }
}
document.getElementById('file_selector').addEventListener('change', fileSelect, false);
document.getElementById('color_select').reset();

function draw_file(file_text){
    onCavnas = [];
    points_array = [];

    gl.clear(gl.COLOR_BUFFER_BIT);
    var file_lines = file_text.split("\n");
//Check for an asterisk line to find the actual "starting line"
    var asterisk = -1;
    for(s in file_lines){
        if(file_lines[s].charAt(0) == "*"){
            asterisk = s;
            break;
        }
    }


document.getElementById('color_selector').addEventListener('change', colorSelect, false);


// go through file, check for asterisk and blank lines
    num_lines = -1;
    for(var i = parseInt(asterisk)+1; i < file_lines.length; i++){
        l = file_lines[i].match(/\S+/g);
        if(!l){continue;}

        if(l.length == 4)
        {
            dimension = [parseFloat(l[0]), parseFloat(l[2]), parseFloat(l[3]), parseFloat(l[1])];
            projMatrix = ortho(dimension[0], dimension[1], dimension[2], dimension[3], -1, 1);
            gl.uniformMatrix4fv(matrix, false, flatten(projMatrix));


        }
        else if(num_lines == -1)
        {
            num_lines = parseFloat(l[0]);
        }
        else
        {
            points = [];
            var points_in_polyline = l[0];
            for(var p = 0; p < points_in_polyline; p){
                i++;
                l = file_lines[i].match(/\S+/g);
                if(!l){continue;}
                p++
                points.push(vec4( parseFloat(l[0]), parseFloat(l[1]), 0.0, 1.0));
            }

            draw_polyline(points);
            onCavnas.push(points);
        }
    }
}

// function for color switching 
function colorSelect(event){
    gl.clear(gl.COLOR_BUFFER_BIT);
    var color = event.target.value;
    var r = parseInt(color.substring(0,3),10)/250;
    var g = parseInt(color.substring(0,5),10)/250;
    var b = parseInt(color.substring(0),10)/250;
    setColor = vec4(r, g, b, 1.0);
    for(s in onCavnas){
        draw_polyline(onCavnas[s]);
    }

}

//cycle through colors
var color_cycle = [vec4(0.0, 0.0, 0.0, 1.0), vec4(1.0, 0.0, 0.0, 1.0), vec4(0.0, 1.0, 0.0, 1.0), vec4(0.0, 0.0, 1.0, 1.0)]

function draw_polyline(points){
    gl.bindBuffer(gl.ARRAY_BUFFER, pbuffer);
    gl.bufferData(gl.ARRAY_BUFFER, flatten(points), gl.STATIC_DRAW)
    colors = []
    for(s in points){
        colors.push(setColor);
    }
    gl.bindBuffer(gl.ARRAY_BUFFER, cbuffer);
    gl.bufferData(gl.ARRAY_BUFFER, flatten(colors), gl.STATIC_DRAW)
    gl.drawArrays(gl.LINE_STRIP, 0, points.length);

}

