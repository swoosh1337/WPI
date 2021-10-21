

// necessary variables
let lightPosition = vec4(0.0, 0.0, 15.0, 0.0 );
let lightAmbient = vec4(0.2, 0.2, 0.2, 1.0 );
let lightDiffuse = vec4( 1.0, 1.0, 1.0, 1.0 );
let lightSpecular = vec4( 1.0, 1.0, 1.0, 1.0 );
let materialSpecular = vec4( 1.0, 1.0, 1.0, 1.0 );
let materialDiffuse, materialAmbient;

// making a sphere
function Sphere(verts, color){

    let vBuffer1 = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, vBuffer1);
    gl.bufferData(gl.ARRAY_BUFFER, flatten(verts), gl.STATIC_DRAW);
    
    materialAmbient = vec4(0.5, 0.5, 0.5, 1.0);
    materialDiffuse = color;

    let ambientProduct = mult(lightAmbient, materialAmbient);
    let diffuseProduct = mult(lightDiffuse, materialDiffuse);
    let specularProduct = mult(lightSpecular, materialSpecular);

    let vPosition = gl.getAttribLocation( program, "vPosition");
    gl.vertexAttribPointer(vPosition, 4, gl.FLOAT, false, 0, 0);
    gl.enableVertexAttribArray(vPosition);


    gl.uniform4fv(gl.getUniformLocation(program, "specularProduct"), flatten(specularProduct));
    gl.uniform4fv(gl.getUniformLocation(program, "ambientProduct"), flatten(ambientProduct));
    gl.uniform4fv(gl.getUniformLocation(program, "diffuseProduct"), flatten(diffuseProduct));


    let vBuffer2 = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, vBuffer2);
    if (!gouraudShading) {
        gl.bufferData(gl.ARRAY_BUFFER, flatten(normalsArray), gl.STATIC_DRAW);
    } else {
        gl.bufferData(gl.ARRAY_BUFFER, flatten(gourandNormal), gl.STATIC_DRAW);
    }

    let vNormal = gl.getAttribLocation(program, "vNormal");
    gl.vertexAttribPointer(vNormal, 4, gl.FLOAT, false, 0, 0);
    gl.enableVertexAttribArray(vNormal);

    for( let i=0; i < verts.length; i+=3)
        gl.drawArrays( gl.TRIANGLES, i, 3 );
}


// making a cube
function make_cube(vertices, objColor){

    let pBuffer;
    pBuffer = gl.createBuffer();
    gl.bindBuffer(gl["ARRAY_BUFFER"], pBuffer);
    gl.bufferData(gl.ARRAY_BUFFER, flatten(vertices), gl.STATIC_DRAW);

    let vPosition = gl.getAttribLocation(program,  "vPosition");
    gl.vertexAttribPointer(vPosition, 4, gl.FLOAT, false, 0, 0);
    gl.enableVertexAttribArray(vPosition);

    materialAmbient = vec4(0.5, 0.5, 0.5, 1.0);
    materialDiffuse = objColor;

    let diffuseProduct = mult(lightDiffuse, materialDiffuse);
    let specularProduct = mult(lightSpecular, materialSpecular);
   let ambientProduct = mult(lightAmbient, materialAmbient);

    gl.uniform4fv(gl.getUniformLocation(program, "diffuseProduct"), flatten(diffuseProduct));
    gl.uniform4fv(gl.getUniformLocation(program, "specularProduct"), flatten(specularProduct));
    gl.uniform4fv(gl.getUniformLocation(program, "ambientProduct"), flatten(ambientProduct));

 let vBuffer2 = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, vBuffer2);
    if(gouraudShading)
        gl.bufferData(gl.ARRAY_BUFFER, flatten(gourandNormal2), gl.STATIC_DRAW);
    else
        gl.bufferData(gl.ARRAY_BUFFER, flatten(normalsArray2), gl.STATIC_DRAW);

    let vNormal = gl.getAttribLocation( program, "vNormal");
    gl.vertexAttribPointer(vNormal, 4, gl.FLOAT, false, 0, 0);
    gl.enableVertexAttribArray(vNormal);

    gl.drawArrays( gl.TRIANGLES, 0, 36);
}




function drawLine(direction, length){

   let linePoints = [];

    if(direction === "v"){  //if we have vertical line
        linePoints.push(vec4(0.0, length/2, 0.0, 1.0));
        linePoints.push(vec4(0.0, -length/2, 0.0, 1.0));
    }
    else{ //horizontal line
        linePoints.push(vec4(length/2, 0.0, 0.0, 1.0));
        linePoints.push(vec4(-length/2, 0.0, 0.0, 1.0));
    }

    let pBuffer = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, pBuffer);
    gl.bufferData(gl.ARRAY_BUFFER, flatten(linePoints), gl.STATIC_DRAW);

   let vPosition = gl.getAttribLocation( program, "vPosition");
    gl.vertexAttribPointer(vPosition, 4, gl.FLOAT, false, 0, 0);
    gl.enableVertexAttribArray(vPosition);

    let flagLoc = gl.getUniformLocation(program, "flag");
    gl.uniform1f(flagLoc, 1.0);

    gl.drawArrays( gl.LINE_STRIP, 0, 2);

    gl.uniform1f(flagLoc, 0.0);
}



