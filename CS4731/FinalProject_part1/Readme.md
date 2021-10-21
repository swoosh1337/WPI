In this project, we will explore hierarchical modeling of 3D meshes. We will also explore lighting and shading. The goal of this part of the assignment is to familiarize yourself with transformations and hierarchical modeling in WebGL using a matrix stack. You will be modeling and animating a kinetic sculpture such as Alexander Calder's hanging mobiles. Example images and an example video are given below: 

First Steps:

Your task is to model and animate a kinetic sculpture. In order to do so, you need to first construct a scene containing several objects, then you need to organize them hierarchically and simulate their motions according to the hierarchy you define. All models should be properly sized so that they do not look disproportionate or display awkwardly. All models should have approximately the same size. In the video, you should have noticed multiple axes of movement for each model, where the model may rotate about it's own axis while rotating around a larger arm off which it is hanging. Implement this effect!! To draw the arms connecting the meshes, you can just draw horizontal lines, and to connect the meshes to the ends of the arm, just draw vertical lines. Also, make sure you set up perspective projection

Gouraud Lighting (smooth shading): Draw all your meshes in your hierarchy as solid meshes (not wireframes). Implement shaders for Gouraud lighting (as demonstrated in class) and flat shading. You will switch between shading types using keystrokes below. Apply some interesting colors and material properties to your 3D meshes. Don't forget to enable depth testing and hidden surface removal.

Implement a spotlight: The spotlight is like a cone, and light only reaches objects inside the cone. Objects outside a certain angle--called the cutoff angle, phi--gets no light from the spotlight (although it may still receive ambient light from the environment). Make the cutoff angle a variable that can be controlled with a keystroke. Make sure the presence of the spotlight is obvious!

Matrix stack: You will need to implement a matrix stack, including stack.push() and stack.pop() routines. You may use a simple linked list to store the stack or use a more sophisticated tree structure.

Animation: Be mindful of performance issues while you implement this homework. As your scene size grows, avoid unnecessary re-initialization, file reopening, etc. that could slow down your program considerably. 

Other Requirements: Your sculpture must consist of at least 6 meshes with interesting colors, including at least three cubes and at least three spheres. Each mesh should have a different color. Your sculpture must contain at least 3 levels of hierarchy. (See the second image at the top of the page.) The animation should move all parts of the sculpture. It should be physically motivated and make sense; that is, there are no magical, free-flying shapes or disjointed movements. Objects should remain connected in whatever way you connected them as you animate them. 

All mesh models should rotate counter-clockwise about their own Y axis. The arms should rotate in the direction opposite of the level above it. For instance, if the arm of Level 1 of the hierarchy rotates clockwise, the arm of level 2 of the hierarchy should rotate counter-clockwise, the arm of level 3 should rotate clockwise, and so on. (You can have the level 1 arm rotate counter-clockwise and alternate from there, too.) Basically, the arms of consecutive levels of the hierarchy should alternate between rotating clockwise and counter-clockwise. 

Additional Keystrokes:

Also implement the following additional keystrokes.

    (User hits 'p'): Increase spotlight cut off angle (increase cone angle)
    (User hits 'P'): Decrease spotlight cut off angle (decrease cone angle) 
    (User hits 'm'): The scene is shaded using Gouraud lighting (smooth shading)
    (User hits 'M'): The scene is shaded using flat shading 

Note that these keys are case-sensitive. If you do not want to worry about case-sensitivity, you are also welcome to implement "i" instead of "P" for "decrease spotlight cut off angle" and "n" instead of "M" for "the scene is shaded using flat shading.
