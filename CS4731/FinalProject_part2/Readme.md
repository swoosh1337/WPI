In this project you will add more realism to your hierarchy from Part I by adding texturing and shadows.

First Steps:

In this project you will load textures in the bmp file format and use them to texture parts of your scene.

Beginning with your Part I submission, add a floor plane below your hierarchy and two walls behind it. You will implement shadows. The floor and walls will be surfaces on which the shadows can be cast. Your floor plane and two walls should be similar to the one shown below. You do not have to render the scene objects (table, rectangular block, lamp shade and teapot).
ou can also reference the texture files at the following URLs:
Grass 	http://web.cs.wpi.edu/~jmcuneo/grass.bmp
Stones 	http://web.cs.wpi.edu/~jmcuneo/stones.bmp
Environment Map - Negative X 	http://web.cs.wpi.edu/~jmcuneo/env_map_sides/nvnegx.bmp
Environment Map - Negative Y 	http://web.cs.wpi.edu/~jmcuneo/env_map_sides/nvnegy.bmp
Environment Map - Negative Z 	http://web.cs.wpi.edu/~jmcuneo/env_map_sides/nvnegz.bmp
Environment Map - Positive X 	http://web.cs.wpi.edu/~jmcuneo/env_map_sides/nvposx.bmp
Environment Map - Positive Y 	http://web.cs.wpi.edu/~jmcuneo/env_map_sides/nvposy.bmp
Environment Map - Positive Z 	http://web.cs.wpi.edu/~jmcuneo/env_map_sides/nvposz.bmp

Texture the floor plane with grass and walls with stone: Texture map some grass onto the floor of your scene to make it look like grass is growing. Use the grass texture file. Make it look like the walls were made of stone by texturing both walls using the stone texture.  Do not try to stretch these small textures over a large floor (or walls). Instead, map each texture to the bottom left corner of the floor (or walls) undistorted and then repeat (i.e. tile) the texture to cover the entire floor. 

Shadows: In class and in your readings, you learned about a simple technique to render shadows using projection. Implement this shadow algorithm such that the shadows of the hierarchy are projected in the direction opposite your light source and updated continuously as the hierarchy spins.

Environment Mapping: Add in reflective and refractive environment mapping using cubemaps to your scene. Use the cube map as your environment map. For reference purposes, the complete environment map looks like this:

 

Below is an image of a cow with reflection and refraction effects

 

Additional Keystrokes:

Key A: Toggle shadows ON/OFF. When ON, the shadows show up and when OFF the shadows do not show up.

Key B: Toggle ON/OFF between a scene with grass texture on floor and stone texture on the walls and a plain wall (no texturing). When ON, the floor is textured with grass and the walls are textured with stone. When OFF the floor and walls have no texturing, displaying a gray floor and blue walls.

Key C: Toggle reflection ON/OFF. When ON, the hierarchy is drawn with reflection. When OFF, the hierarchy objects are drawn with no reflection (rendered as a solid model(s) with Gouraud lighting). Select an appropriate shininess (reflectivity) for the models.

Key D: Toggle refraction ON/OFF. When ON, the hierarchy is drawn with refraction. When OFF, the hierarchy is drawn with no refraction ( rendered as a solid model(s) with Gouraud lighting). Select an appropriate refractive index for the hierarchy.

Extra Credit:

For this project, you are allowed to include additional features above and beyond the basic requirements. The instructor has sole discretion over the point value of each feature, and the student may earn up to 10 points total. To earn any credit, you must list each feature in the comments at the top of your main *.js file.

To be eligible for extra credit, the additional features must be graphical in nature. This means that you show thought behind how something is presented to the user on screen or how the graphics are being processed behind the scenes. 

Submitting Your Work:

Make sure to double-check that everything works before submitting. Put all of your files (JavaScript, HTML, etc.) into a folder and zip it. Please include your *.ply files for ease of grading. Upload it to Canvas. Do not email me your program or submit it via a third-party cloud storage account.

Create documentation for your program and submit it along with the project inside the zip file. Your documentation can be either a pure ASCII text or a Microsoft Word file. The documentation does not have to be long. Briefly describe the structure of your program and what each file turned in contains. Name your zip file according to the convention LastnameFirstname_Final2.zip.

Additional Notes:

    You are free to consult any resources you need to help you complete this assignment, including your classmates, the TA, the instructor, the class text, and any other books and websites. However, the code you turn in must be your own. Any evidence of plagiarism will result in an automatic 0 for this assignment.
    You are welcome to use any class coding examples (posted under "Modules") in your program. You are also welcome to use any code that the textbook authors (Angel and Shreiner) provide you.
