// NECESSARY VARIABLES
let grassSrc = "http://web.cs.wpi.edu/~jmcuneo/grass.bmp", stoneSrc = "http://web.cs.wpi.edu/~jmcuneo/stones.bmp",
    min = 0.0, max = 5.0, grass, stone, texture, vTexCoord, loadImage1, loadImage2; loadImage2   = loadImage1 = false;

let textCoord = [
    vec2(min, min),
    vec2(min, max),
    vec2(max, max),
    vec2(max, min)];

//creating texture
let createTexture;
createTexture = color => {
    let tex;
    tex = gl.createTexture();
    gl.bindTexture(gl.TEXTURE_2D, tex);
    gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, 1, 1, 0, gl.RGBA, gl.UNSIGNED_BYTE,
        new Uint8Array([color[0] * 245, color[1] * 245, color[2] * 245, 245]));

    gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MIN_FILTER, gl.NEAREST);
    gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MAG_FILTER, gl.NEAREST);
};

//setting background image
function image(){
    stone = new Image();
    stone.crossOrigin = "";
    stone.src = stoneSrc;
    grass = new Image();
    grass.crossOrigin = "";
    grass.src = grassSrc;
    grass.onload = () => {
        loadImage1 = true;
    };
    stone.onload = () => {
        loadImage2 = true;
    };

    createTexture(vec4(0.5, 0.5, 0.5, 1.0));
}

const environment = img => {
    texture = gl.createTexture();

    gl.activeTexture(gl.TEXTURE0);
    gl.bindTexture( gl.TEXTURE_2D, texture );
    gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_T, gl.REPEAT);
    gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_S, gl.REPEAT);
    gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MIN_FILTER, gl.NEAREST );
    gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MAG_FILTER, gl.NEAREST );
    gl.texImage2D( gl.TEXTURE_2D, 0, gl.RGB, gl.RGB, gl.UNSIGNED_BYTE, img);
    gl.uniform1i(gl.getUniformLocation(program, "texture"), 0);
};