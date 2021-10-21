Begin this project by writing a simple WebGL program that can read in a .ply file and render the drawing to the screen. To read in a .ply file, you should use a file upload button like you did in Project 1.

    Start testing your program with the cube.ply file. It's much simpler than the other meshes, so it will be easier for you to diagnose and debug problems. 
    You should be able to use a fair amount of your Project 1 code for this part of the project.
    Note that the .ply files do NOT offer extent boundaries like the .dat files in Project 1. You will have to use the vertex information to figure out your own extents. Remember that you still need to ensure that all files observe the correct aspect ratio!
    Please use a perspective projection, not an orthographic one.
    After you have determined the extents of the mesh, you should use the lookAt() function to move your camera some fixed distance away from the mesh. The edges of the mesh should not be flush against the edges of your canvas!
    These meshes are 3D, so you will need to account for depth in your program.
    For ease of legibility, I recommend a white line color against a black background.

Part II: Pulsing

First, calculate the normal of each mesh face (i.e. each polygon) using the Newell method. 

Then, create a pulsing animation by translating each face some fixed amount in its normal direction. By linearly interpolating the position of each vertex belonging to a given face between its original position and v+cn (where c is a constant) and then interpolating back in the opposite direction, we can make the mesh bulge outward and then recede in a smooth fashion. This operation should make the meshes look like they are "breathing" back and forth.

Notes:

    Note that when the mesh breathes in, the faces of the mesh are in their original positions, and when the mesh breathes out, the faces move outwards and temporarily separate from neighboring faces.
    Make sure the faces move out enough for the bulging effect to be noticeable and make the face movements nice and smooth (Not too fast).
    You will need to use current transformation matrices (CTMs) on each face to translate it accordingly.

Part III: Keyboard Controls

Implement the following keyboard controls in your program:

    User hits 'X' (Translate your wireframe in the positive x direction) Continuously animate your wireframe some small units along the positive X axis. The ply file should continue to slide along until the user hits 'X' again. Essentially, the 'X' key acts as a toggle key. The speed is up to you, but it should not be too fast or slow.
    User hits 'C' (Translate your wireframe in the negative x direction)
    User hits 'Y' (Translate your wireframe in the positive y direction)
    User hits 'U' (Translate your wireframe in the negative y direction)
    User hits 'Z' (Translate your wireframe in the positive z direction)
    User hits 'A' (Translate your wireframe in the negative z direction)
    User hits 'R' (Rotate your wireframe in an X-roll about it's CURRENT position) Just like a rotisserie chicken, continuously animate your wireframe smoothly 360 degrees at a moderate speed (X-roll) about its CURRENT position (not about the center of the scene). This rotation is NOT the same as moving the wireframe in a wide arc. The rotation should be about the X axis. 
    User hits Key 'B': Toggle pulsing meshes ON/OFF. When ON, the mesh faces pulse back and forth continuously as described above. When OFF the meshes do not pulse. 

Notes:

    The camera position should remain fixed even if the mesh is moving. 
    The model should be able to translate, rotate, and pulse at the same time. It only needs to translate in one direction at a time.
    If a translation, rotation, or pulse is stopped and started again, the model should pick right back up from where it stopped (i.e. do not "reset" the model).
    Your animation may run at different speeds depending on the complexity of the mesh you're using. This is normal given the amount of work that your CPU and GPU have to do for each frame. However, please make a point of minimizing the amount of redundant work your program does. For instance, you should only be calculating and passing your projection matrix once each time you select a file.
