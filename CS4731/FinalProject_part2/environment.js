// NECESSARY VARIABLES
let cubeMap, red = new Uint8Array([255, 0, 0, 255]), blue = new Uint8Array([0, 0, 255, 255]),
    green = new Uint8Array([0, 255, 0, 255]), cyan = new Uint8Array([0, 255, 255, 255]),
    magenta = new Uint8Array([255, 0, 255, 255]), yellow = new Uint8Array([255, 255, 0, 255]), imageLinks, eImage = [],
    n = 0;


// function for cube mapping
function cube_map() {
    cubeMap = gl.createTexture();

    gl.activeTexture(gl.TEXTURE1);
    gl.bindTexture(gl.TEXTURE_CUBE_MAP, cubeMap);
    gl.texParameteri(gl.TEXTURE_CUBE_MAP, gl.TEXTURE_WRAP_S, gl.CLAMP_TO_EDGE);
    gl.texParameteri(gl.TEXTURE_CUBE_MAP, gl.TEXTURE_WRAP_T, gl.CLAMP_TO_EDGE);
    gl.texImage2D(gl.TEXTURE_CUBE_MAP_POSITIVE_X, 0, gl.RGBA, gl.RGBA, gl.UNSIGNED_BYTE, eImage[0]);
    gl.texImage2D(gl.TEXTURE_CUBE_MAP_POSITIVE_Y, 0, gl.RGBA, gl.RGBA, gl.UNSIGNED_BYTE, eImage[1]);
    gl.texImage2D(gl.TEXTURE_CUBE_MAP_POSITIVE_Z, 0, gl.RGBA, gl.RGBA, gl.UNSIGNED_BYTE, eImage[2]);
    gl.texImage2D(gl.TEXTURE_CUBE_MAP_NEGATIVE_X, 0, gl.RGBA, gl.RGBA, gl.UNSIGNED_BYTE, eImage[3]);
    gl.texImage2D(gl.TEXTURE_CUBE_MAP_NEGATIVE_Y, 0, gl.RGBA, gl.RGBA, gl.UNSIGNED_BYTE, eImage[4]);
    gl.texImage2D(gl.TEXTURE_CUBE_MAP_NEGATIVE_Z, 0, gl.RGBA, gl.RGBA, gl.UNSIGNED_BYTE, eImage[5]);
    gl.texParameteri(gl.TEXTURE_CUBE_MAP, gl.TEXTURE_MAG_FILTER, gl.NEAREST);
    gl.texParameteri(gl.TEXTURE_CUBE_MAP, gl.TEXTURE_MIN_FILTER, gl.NEAREST);
    gl.uniform1i(gl.getUniformLocation(program, "texMap"), 1);

}



//function for environment setting
function setEnv(){

    imageLinks = [
        'http://web.cs.wpi.edu/~jmcuneo/env_map_sides/nvnegx.bmp',
        'http://web.cs.wpi.edu/~jmcuneo/env_map_sides/nvnegy.bmp',
        'http://web.cs.wpi.edu/~jmcuneo/env_map_sides/nvnegz.bmp',
        'http://web.cs.wpi.edu/~jmcuneo/env_map_sides/nvposx.bmp',
        'http://web.cs.wpi.edu/~jmcuneo/env_map_sides/nvposy.bmp',
        'http://web.cs.wpi.edu/~jmcuneo/env_map_sides/nvposz.bmp',

    ];

    cubemap();
    for(let i = 0; 6 > i; i++) {
        let img = new Image();
        img["crossOrigin"] = "";
        img["src"] = imageLinks[i];
        eImage.push(img);
        img["onload"] = function () {
            n++;
            if (n !== 6) {
                return;
            }
            cube_map();
        };
    }
}
const cubemap = () => {
    cubeMap = gl.createTexture();

    gl.activeTexture(gl.TEXTURE0);
    gl.bindTexture(gl.TEXTURE_CUBE_MAP, cubeMap);
    gl.texParameteri(gl.TEXTURE_CUBE_MAP, gl.TEXTURE_WRAP_S, gl.CLAMP_TO_EDGE);
    gl.texParameteri(gl.TEXTURE_CUBE_MAP, gl.TEXTURE_WRAP_T, gl.CLAMP_TO_EDGE);
    gl.texImage2D(gl.TEXTURE_CUBE_MAP_POSITIVE_X, 0, gl.RGBA, 1, 1, 0, gl.RGBA, gl.UNSIGNED_BYTE, red);
    gl.texImage2D(gl.TEXTURE_CUBE_MAP_POSITIVE_Y, 0, gl.RGBA, 1, 1, 0, gl.RGBA, gl.UNSIGNED_BYTE, blue);
    gl.texImage2D(gl.TEXTURE_CUBE_MAP_POSITIVE_Z, 0, gl.RGBA, 1, 1, 0, gl.RGBA, gl.UNSIGNED_BYTE, yellow);
    gl.texImage2D(gl.TEXTURE_CUBE_MAP_NEGATIVE_X, 0, gl.RGBA, 1, 1, 0, gl.RGBA, gl.UNSIGNED_BYTE, cyan);
    gl.texImage2D(gl.TEXTURE_CUBE_MAP_NEGATIVE_Y, 0, gl.RGBA, 1, 1, 0, gl.RGBA, gl.UNSIGNED_BYTE, magenta);
    gl.texImage2D(gl.TEXTURE_CUBE_MAP_NEGATIVE_Z, 0, gl.RGBA, 1, 1, 0, gl.RGBA, gl.UNSIGNED_BYTE, green);
    gl.texParameteri(gl.TEXTURE_CUBE_MAP, gl.TEXTURE_MAG_FILTER, gl.NEAREST);
    gl.texParameteri(gl.TEXTURE_CUBE_MAP, gl.TEXTURE_MIN_FILTER, gl.NEAREST);
    gl.uniform1i(gl.getUniformLocation(program, "texMap"), 0);

};
