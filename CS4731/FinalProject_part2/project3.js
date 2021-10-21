// necessary variables
let points,gl,program,mvMatrix, pMatrix,modelView, projection,cubik,id,gourandNormal2;
let spiko,normalsArray1,normalsArray2,gourandNormal,ratio,reflectOn, refractOn;
let smoothShading = true;
let stack = [];
let theta, alpha, omega ;
alpha = theta = omega = 0;
let animate, shadowOn,textureOn;
animate = shadowOn = textureOn = true;
reflectOn = refractOn = false;
let materialDiffuse,materialAmbient;
let materialShininess = 35.0;
let light_limit = 0.8;

function main(){

    let i;
    let canvas = document.getElementById('webgl');
    gl = WebGLUtils.setupWebGL(canvas, undefined);
    if (!gl)
    {
        console.log('Failed to get the rendering context for WebGL');
        return;
    }

    // initialing shaders
    program = initShaders(gl, "vshader", "fshader");
    gl.useProgram(program);
    gl.viewport( 0, 0, canvas.width, canvas.height);
    ratio = canvas.width/canvas.height;

    
    gl.clearColor(0.0, 0.0, 0.0, 1.0);

    gl.enable(gl.DEPTH_TEST);

    gl.uniform4fv(gl.getUniformLocation(program, "lightPos"), flatten(lightPos));
    gl.uniform1f(gl.getUniformLocation(program, "shininess"), materialShininess);

    points = [];
    normalsArray1= [];
    normalsArray2 = [];
    gourandNormal = [];
    gourandNormal2 = [];
    spiko = [];

    //sphere making
    sphere({a: va, b: vb, c: vc, d: vd, n: num});
    //calculating normals
    normalsArray1 = calcualte_normal(spiko);
    //making cube
    cubik = cube();

    //calculating cube normals
    normalsArray2 = calcualte_normal(cubik);
    let vertz = [];
    for(i = 0; cubik.length > i; i++){
        vertz = cubik[i];
        gourandNormal2.push(vertz[0], vertz[1], vertz[2], 0.0);
    }

    projection = gl.getUniformLocation(program, "projectionMatrix");
    modelView = gl.getUniformLocation(program, "modelMatrix");
    gl.clear( gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);
    

    pMatrix = perspective(45, ratio, .1, 60);
    gl.uniformMatrix4fv( projection, false, flatten(pMatrix) );
    let eye = vec3(0, 0, 30), at = vec3(0, 0, 0), up = vec3(0, 1, 0);
    mvMatrix = lookAt(eye, at , up);
    render();
    setEnv();
    image();
    
}

function calcualte_normal(vertices){
    let arr = [], mx = 0, my = 0, mz = 0, x1, x2, y1, y2, z1, z2, ver, magnitude, normal;
    for(let k = 0; vertices.length > k; k+=3){
        for (const x of ver = []) {
            ver.push(vertices[k]);
            ver.push(vertices[k+1]);
            ver.push(vertices[k+2]);
            ver.push(vertices[k]);
        };

        mx = 0; my = 0; mz = 0;

        //getting x y z
        for(let i = 0; ver.length - 1 > i; i++){
            const [first, second, third] = ver[i];
            mx += (y1 - y2) * (z1 + z2);
            my += (z1 - z2) * (x1 + x2);
            mz += (x1 - x2) * (y1 + y2);
            x1 = first; x2 = ver[i+1][0];
            y1 = second; y2 = ver[i+1][1];
            z1 = third; z2 = ver[i+1][2];

        }

        magnitude = Math.sqrt(mx*mx + my*my + mz*mz);   //NORMAL VECTOR MAGNITUDE
        normal = vec3(mx/magnitude, my/magnitude, mz/magnitude);
        const [first1, second1, third1] = normal;
        arr.push(first1, second1, third1, 0.0);
        arr.push(first1, second1, third1, 0.0);
        arr.push(first1, second1, third1, 0.0);
    }
    return arr;
}

function makeObject(draw, param1, param2, xPos = 0, yPos = 0, zPos = 0){
    stack.push(mvMatrix);
    // translating
        mvMatrix = mult(mvMatrix, translate(xPos, yPos, zPos));
        gl.uniformMatrix4fv( modelView, false, flatten(mvMatrix) );
        draw(param1, param2);
    mvMatrix = stack.pop();
}

//function for rotation
function yAxisRotation(xPos, angle){
    let rotMatrix;
    rotMatrix = mult(translate(-xPos, 0, 0), mult(rotateY(angle), translate(xPos, 0, 0)));
    mvMatrix = mult(mvMatrix, rotMatrix);
}

//for all keystrokes
function onclick(){
    let key;
    const {key: key1} = event;
    key = key1;
    if (key === 'A') {// shadow on/off
        shadowOn = !shadowOn;
        if (!animate)
            render();
    } else if (key === 'B') {//  texture on/off
        textureOn = !textureOn;
        if (!animate)
            render();
    } else if (key === 'C') {// reflection on/ff
        reflectOn = !reflectOn;

        if (refractOn && reflectOn)
            gl.uniform1f(gl.getUniformLocation(program, "reflectRefract"), 3.0);
        else if (refractOn)
            gl.uniform1f(gl.getUniformLocation(program, "reflectRefract"), 2.0);
        else if (reflectOn)
            gl.uniform1f(gl.getUniformLocation(program, "reflectRefract"), 1.0);
        else
            gl.uniform1f(gl.getUniformLocation(program, "reflectRefract"), 0.0);

        if (!animate)
            render();
    } else {
        if (key === 'D') {//toggle refraction on and off
            refractOn = !refractOn;

            if (reflectOn) {
                if (refractOn) gl.uniform1f(gl.getUniformLocation(program, "reflectRefract"), 3.0); else if (refractOn)
                    gl.uniform1f(gl.getUniformLocation(program, "reflectRefract"), 2.0);
                else if (reflectOn)
                    gl.uniform1f(gl.getUniformLocation(program, "reflectRefract"), 1.0);
                else
                    gl.uniform1f(gl.getUniformLocation(program, "reflectRefract"), 0.0);
            } else if (refractOn)
                gl.uniform1f(gl.getUniformLocation(program, "reflectRefract"), 2.0);
            else if (reflectOn)
                gl.uniform1f(gl.getUniformLocation(program, "reflectRefract"), 1.0);
            else
                gl.uniform1f(gl.getUniformLocation(program, "reflectRefract"), 0.0);
            if (!animate)
                render();
        } else {
        }
    }
}

// setting background
function background(){

    stack.push(mvMatrix);
    mvMatrix = mult(mvMatrix, mult(translate(0, -17, 0), rotateX(90)));
    drawPlane(vec4(0.5, 0.5, 0.5, 1.0), grass);
    mvMatrix = stack.pop();
    stack.push(mvMatrix);
    mvMatrix = mult(mvMatrix, mult(translate(-a,  0, 0), rotateY(75)));
    drawPlane(vec4(0.5, 0.0, 0.5, 1.0), stone);
    mvMatrix = stack.pop();
    stack.push(mvMatrix);
    mvMatrix = mult(mvMatrix, mult(translate(a, 0, 0), rotateY(-75)));
    drawPlane(vec4(0.7, 0.0, 0.5, 1.0), stone);
    mvMatrix = stack.pop();
    stack.push(mvMatrix);
    mvMatrix = mult(mvMatrix, translate(0, 0, -a));
    drawPlane(vec4(0.7, 0.7, 1.5, 1.0), stone);
    mvMatrix = stack.pop();
}


function render(){

    let flag;
    gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);
    background();
    gl.uniform1f(gl.getUniformLocation(program, "cutoff"), light_limit);
    flag = gl.getUniformLocation(program, "flag");
    gl.uniform1f(flag, 0.0);

    stack.push(mvMatrix);
    mvMatrix = mult(mvMatrix, rotateY(theta));
    makeObject(Sphere, spiko, vec4(0.0, 0.0, 1.0, 1.0), 0, 5); //blue sphere
    makeObject(make_line, "h", 8, 0, 2.5);
    makeObject(make_line, "v", 2.5, 0, 3.75);
    makeObject(make_line, "v", 2.5, -4, 1.25);
    makeObject(make_line, "v", 2.5, 4, 1.25);
    stack.push(mvMatrix);
    yAxisRotation(4, alpha);
    makeObject(make_cube, cubik, vec4(0.0, 1.0, 0.0, 1.0), -4, 0);  //green cube
    makeObject(make_line, "h", 4, -4, -2.5);
    makeObject(make_line, "v", 2.5, -4, -1.25);
    makeObject(make_line, "v", 2.5, -6, -3.75);
    makeObject(make_line, "v", 2.5, -2, -3.75);
    stack.push(mvMatrix);
    yAxisRotation(6, omega);
    makeObject(make_cube, cubik, vec4(1.0, 1.0, 0.0, 1.0), -6, -5);  //yellow cube
    mvMatrix = stack.pop();
    stack.push(mvMatrix);
    yAxisRotation(2, omega);
    makeObject(make_cube, cubik, vec4(1.0, 0.0, 0.0, 1.0), -2, -5); //red cube
    mvMatrix = stack.pop();
    mvMatrix = stack.pop();
    stack.push(mvMatrix);
    yAxisRotation(-4, alpha);
    makeObject(Sphere, spiko, vec4(0.0, 0.7, 1.0, 1.0), 4); //cyan sphere
    makeObject(make_line, "h", 4, 4, -2.5);
    makeObject(make_line, "v", 2.5, 4, -1.25);
    makeObject(make_line, "v", 2.5, 6, -3.75);
    makeObject(make_line, "v", 2.5, 2, -3.75);
    stack.push(mvMatrix);
    yAxisRotation(-2, omega);
    makeObject(Sphere, spiko, vec4(1.0, 0.0, 1.0, 1.0), 2, -5);  //magenta sphere
    mvMatrix = stack.pop();
    stack.push(mvMatrix);
    yAxisRotation(-6, omega);
    makeObject(Sphere, spiko, vec4(0.5, 0.5, 0.5, 1.0), 6, -5); //grey sphere
    mvMatrix = stack.pop();
    mvMatrix = stack.pop();
    mvMatrix = stack.pop();
    window["onkeypress"] = onclick;
    if (!shadowOn) {
    } else {
        set();
    }

    if (!animate) {
        cancelAnimationFrame(id);
    } else {
        theta += 1.0;  //counter clockwise
        alpha -= 6.0;  //clockwise
        omega += 8.0;  //counter clockwise

        id = requestAnimationFrame(render);
    }
}