
// for drawing the sphere
let num = 5;
let index = 0;
let  va = vec4(0.0, 0.0, -1.0,1);
let vb = vec4(0.0, 0.9, 0.3, 1);
let vc = vec4(-0.8, -0.4, 0.3, 1);
let vd = vec4(0.8, -0.4, 0.3,1);


//helper function get the vertices need for a cube
function quad(a, b, c, d) {
    let vertex = [];

    let vertices = [
        vec4(-1.0, -1.0, 1.0, 1.0),
        vec4(-1.0, 1.0, 1.0, 1.0),
        vec4(1.0, 1.0, 1.0, 1.0),
        vec4(1.0, -1.0, 1.0, 1.0),
        vec4(-1.0, -1.0, -1.0, 1.0),
        vec4(-1.0, 1.0, -1.0, 1.0),
        vec4(1.0, 1.0, -1.0, 1.0),
        vec4(1.0, -1.0, -1.0, 1.0)
    ];
  let indices = [a, b, c, a, c, d];
   let v;

    for (let i = 0; i < indices.length; ++i){
        v = vertices[indices[i]];
        vertex.push(v);
    }

    return vertex;
}


function divideTriangle(a, b, c, n){
    if (n <= 0) {
        spiko.push(a);
        spiko.push(c);
        spiko.push(b);

        gourandNormal.push(c[0], c[1], c[2], 0.0);
        gourandNormal.push(b[0], b[1], b[2], 0.0);
        gourandNormal.push(a[0], a[0b1], a[2], 0.0);


        index += 3;
    } else {

     let ab = mix(a, b, 0.5);
     let ac = mix(a, c, 0.5);
     let bc = mix(b, c, 0.5);

        ab = normalize(ab, true);
        ac = normalize(ac, true);
        bc = normalize(bc, true);

        divideTriangle(a, ab, ac, n - 1);
        divideTriangle(ab, b, bc, n - 1);
        divideTriangle(bc, c, ac, n - 1);
        divideTriangle(ab, bc, ac, n - 1);
    }
}


function sphere(a, b, c, d, n){
    divideTriangle(a, b, c, n);
    divideTriangle(d, c, b, n);
    divideTriangle(a, d, b, n);
    divideTriangle(a, c, d, n);
}


function cube(){
    let vertex = [];
    vertex = vertex.concat(quad( 1, 0, 3, 2 ));
    vertex = vertex.concat(quad( 2, 3, 7, 6 ));
    vertex = vertex.concat(quad( 3, 0, 4, 7 ));
    vertex = vertex.concat(quad( 6, 5, 1, 2 ));
    vertex = vertex.concat(quad( 4, 5, 6, 7 ));
    vertex = vertex.concat(quad( 5, 4, 0, 1 ));
    return vertex;
}