// making shaddows
const set = () => {
    for (let x of m = mat4()) {
        
    };
    m[3][3] = 0;
    m[3][2] = -1/lightPos[2];
    const flag = gl.getUniformLocation(program, "flag");
    gl.uniform1f(flag, 3.0);

    shadow({"xPos": 0});
    makeObject(Sphere, spiko, vec4(0.0, 0.0, 1.0, 1.0), 0, 5); 
    mvMatrix = stack.pop();
    shadow({"xPos": 4});
    yAxisRotation(4, alpha);
    makeObject(make_cube, cubik, vec4(0.0, 1.0, 0.0, 1.0), -4,0);  
    mvMatrix = stack.pop();
    shadow({"xPos": -4});
    yAxisRotation(-4, alpha);
    makeObject(Sphere, spiko, vec4(1.0, 1.0, 0.0, 1.0), 4); 
    mvMatrix = stack.pop();
    shadow({"xPos": 6});
    yAxisRotation(4, alpha);
    yAxisRotation(6, omega);
    makeObject(make_cube, cubik, vec4(1.0, 1.0, 0.0, 1.0), -6, -5);  
    mvMatrix = stack.pop();
    shadow({"xPos": 2});
    yAxisRotation(4, alpha);
    yAxisRotation(2, omega);
    makeObject(make_cube, cubik, vec4(1.0, 0.0, 0.0, 1.0), -2, -5); 
    mvMatrix = stack.pop();
    shadow({"xPos": -6});
    yAxisRotation(-4, alpha);
    yAxisRotation(-6, omega);
    makeObject(Sphere, spiko, vec4(0.5, 0.5, 0.5, 1.0), 6, -5); 
    mvMatrix = stack.pop();
    shadow({"xPos": -2});
    yAxisRotation(-4, alpha);
    yAxisRotation(-2, omega);
    makeObject(Sphere, spiko, vec4(0.5, 0.5, 0.5, 1.0), 2, -5);  
    mvMatrix = stack.pop();
};

//function for shadows
function shadow({xPos}){
    var xTrans = (a-1) * ((xPos*Math.cos(theta*Math.PI/150) - lightPos[0])) / lightPos[2];

    stack.push(mvMatrix);
    mvMatrix = mult(mvMatrix, translate(-xTrans, 0, -a+1));
    mvMatrix = mult(mvMatrix, translate(lightPos[0], lightPos[1], lightPos[2]));
    mvMatrix = mult(mvMatrix, m);
    mvMatrix = mult(mvMatrix, translate(-lightPos[0], -lightPos[1], -lightPos[2]));
    mvMatrix = mult(mvMatrix, rotateY(theta));
}