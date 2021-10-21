// necessary variables
let lightPos = vec4(0.0, 0.0, 15.0, 0.0), lightAmbient = vec4(0.2, 0.2, 0.2, 1.0),
    lightDiffuse = vec4(1.0, 1.0, 1.0, 1.0), lightSpecular = vec4(1.0, 1.0, 1.0, 1.0),
    materialSpecular = vec4(1.0, 1.0, 1.0, 1.0);

// function for sphere-making
const Sphere = (verts, color) => {

    let vBuffer1 = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, vBuffer1);
    gl.bufferData(gl.ARRAY_BUFFER, flatten(verts), gl.STATIC_DRAW);
    let vPosition = gl.getAttribLocation( program, "vPosition");
    gl.vertexAttribPointer(vPosition, 4, gl.FLOAT, false, 0, 0);
    gl.enableVertexAttribArray(vPosition);

    materialAmbient = vec4(0.5, 0.5, 0.5, 1.0);
    materialDiffuse = color;

    let diffuseProduct = mult(lightDiffuse, materialDiffuse);
    let specularProduct = mult(lightSpecular, materialSpecular);
    let ambientProduct = mult(lightAmbient, materialAmbient);

    gl.uniform4fv(gl.getUniformLocation(program, "diffuseProduct"), flatten(diffuseProduct));
    gl.uniform4fv(gl.getUniformLocation(program, "specularProduct"), flatten(specularProduct));
    gl.uniform4fv(gl.getUniformLocation(program, "ambientProduct"), flatten(ambientProduct));

    let vBuffer2 = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, vBuffer2);
    if (!smoothShading) {
        gl.bufferData(gl.ARRAY_BUFFER, flatten(normalsArray), gl.STATIC_DRAW);
    } else {
        gl.bufferData(gl.ARRAY_BUFFER, flatten(gourandNormal), gl.STATIC_DRAW);
    }

    let vNormal = gl.getAttribLocation( program, "vNormal");
    gl.vertexAttribPointer(vNormal, 4, gl.FLOAT, false, 0, 0);
    gl.enableVertexAttribArray(vNormal);
    gl.disableVertexAttribArray( vTexCoord );

    for(let j=0; verts.length > j; j+=3) {
        gl.drawArrays(gl.TRIANGLES, j, 3);
    }
};

function make_cube(verts, color){

    let pBuffer = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, pBuffer);
    gl.bufferData(gl.ARRAY_BUFFER, flatten(verts), gl.STATIC_DRAW);
    let vPosition = gl.getAttribLocation(program,  "vPosition");
    gl.vertexAttribPointer(vPosition, 4, gl.FLOAT, false, 0, 0);
    gl.enableVertexAttribArray(vPosition);

    materialAmbient = vec4(0.5, 0.5, 0.5, 1.0);
    materialDiffuse = color;
    let diffuseProduct = mult(lightDiffuse, materialDiffuse), specularProduct = mult(lightSpecular, materialSpecular),
        ambientProduct = mult(lightAmbient, materialAmbient);
    gl.uniform4fv(gl.getUniformLocation(program, "diffuseProduct"), flatten(diffuseProduct));
    gl.uniform4fv(gl.getUniformLocation(program, "specularProduct"), flatten(specularProduct));
    gl.uniform4fv(gl.getUniformLocation(program, "ambientProduct"), flatten(ambientProduct));

    let vBuffer2 = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, vBuffer2);
    if (!smoothShading) {
        gl.bufferData(gl.ARRAY_BUFFER, flatten(normalsArray2), gl.STATIC_DRAW);
    } else {
        gl.bufferData(gl.ARRAY_BUFFER, flatten(gourandNormal2), gl.STATIC_DRAW);
    }

    let vNormal = gl.getAttribLocation( program, "vNormal");
    gl.vertexAttribPointer(vNormal, 4, gl.FLOAT, false, 0, 0);
    gl.enableVertexAttribArray(vNormal);
    gl.disableVertexAttribArray( vTexCoord );
    gl.drawArrays( gl.TRIANGLES, 0, 36);
}

const make_line = (direction, length) => {

    let linePoints = [];
    if ("v" !== direction) { //horizontal line
        linePoints.push(vec4(length >> 1, 0.0, 0.0, 1.0));
        linePoints.push(vec4(-length >> 1, 0.0, 0.0, 1.0));
    } else {  //if we have vertical line
        linePoints.push(vec4(0.0, length >> 1, 0.0, 1.0));
        linePoints.push(vec4(0.0, -length >> 1, 0.0, 1.0));
    }

    let pBuffer = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, pBuffer);
    gl.bufferData(gl.ARRAY_BUFFER, flatten(linePoints), gl.STATIC_DRAW);

    let vPosition = gl.getAttribLocation( program, "vPosition");
    gl.vertexAttribPointer(vPosition, 4, gl.FLOAT, false, 0, 0);
    gl.enableVertexAttribArray(vPosition);
    gl.disableVertexAttribArray( vTexCoord );

    let flag;
    flag = gl.getUniformLocation(program, "flag");
    gl.uniform1f(flag, 1.0);
    gl.drawArrays( gl.LINE_STRIP, 0, 2);
    gl.uniform1f(flag, 0.0);
};

//draws a plane
const drawPlane = (colour, image) => {
    gl.uniformMatrix4fv(modelView, false, flatten(mvMatrix));
    let pBuffer = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, pBuffer);
    gl.bufferData(gl.ARRAY_BUFFER, flatten(planeArray), gl.STATIC_DRAW);

    let vPosition = gl.getAttribLocation(program,  "vPosition");
    gl.vertexAttribPointer(vPosition, 4, gl.FLOAT, false, 0, 0);
    gl.enableVertexAttribArray(vPosition);

    let tBuffer = gl.createBuffer();
    gl.bindBuffer( gl.ARRAY_BUFFER, tBuffer );
    gl.bufferData( gl.ARRAY_BUFFER, flatten(textCoord), gl.STATIC_DRAW );

    vTexCoord = gl.getAttribLocation( program, "vTexCoord" );
    gl.vertexAttribPointer( vTexCoord, 2, gl.FLOAT, false, 0, 0 );
    gl.enableVertexAttribArray( vTexCoord );

    let flag = gl.getUniformLocation(program, "flag");
    gl.uniform1f(flag, 2.0);

    if (!(loadImage2 && loadImage1)) {
        createTexture(colour);
    } else {
        if (textureOn) environment(image); else createTexture(colour);
    }

    gl.drawArrays( gl.TRIANGLE_FAN, 0, 4);
};