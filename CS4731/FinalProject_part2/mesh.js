// necessary variables
let num = 5, index = 0, va = vec4(0.0, 0.0, -1.0, 1), vb = vec4(0.0, 0.9, 0.3, 1), vc = vec4(-0.8, -0.4, 0.3, 1),
    vd = vec4(0.8, -0.4, 0.3, 1), a = 22.0, planeArray = [
        vec4(-a, -a, 0.0, 1.0),
        vec4(-a, a, 0.0, 1.0),
        vec4(a, a, 0.0, 1.0),
        vec4(a, -a, 0.0, 1.0)];


//helper  for a cube
function quad(a, b, c, d) {
    let vertex = [], vertices = [
        vec4(-1.0, -1.0, 1.0, 1.0),
        vec4(-1.0, 1.0, 1.0, 1.0),
        vec4(1.0, 1.0, 1.0, 1.0),
        vec4(1.0, -1.0, 1.0, 1.0),
        vec4(-1.0, -1.0, -1.0, 1.0),
        vec4(-1.0, 1.0, -1.0, 1.0),
        vec4(1.0, 1.0, -1.0, 1.0),
        vec4(1.0, -1.0, -1.0, 1.0)
    ], indices = [a, b, c, a, c, d], v;

    for (let i = 0; indices["length"] > i; ++i){
        v = vertices[indices[i]];
        vertex.push(v);
    }

    return vertex;
}

//DIVIDING TRIANGLE FOR BETTER SURFACE
function divideTriangle(a, b, c, n) {
    if (n > 0b0) {
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

    } else {
        index += 3;
        spiko.push(a);
        spiko.push(c);
        spiko.push(b);
        gourandNormal.push(c[0], c[1], c[2], 0.0);
        gourandNormal.push(a[0], a[1], a[2], 0.0);
        gourandNormal.push(b[0], b[1], b[2], 0.0);


    }
}



function sphere({a, b, c, d, n}){
    divideTriangle(a, b, c, n);
    divideTriangle(d, c, b, n);
    divideTriangle(a, d, b, n);
    divideTriangle(a, c, d, n);
}


function cube(){
    let vertex = [];
    vertex = vertex.concat(quad(0b1, 0, 3, 2 ));
    vertex = vertex.concat(quad(0b10, 3, 7, 6 ));
    vertex = vertex.concat(quad(0b11, 0, 4, 7 ));
    vertex = vertex.concat(quad(0b101, 6, 1, 2 ));
    vertex = vertex.concat(quad(0b100, 5, 6, 7 ));
    vertex = vertex.concat(quad(0b101, 4, 0, 1 ));
    return vertex;
}





