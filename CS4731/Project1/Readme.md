Part I: File Mode

For this part, the user will upload a file with a .dat extension. The file will consist of lines of numbers formatted as follows:

    The file may or may not begin with one or more rows of text followed by a line starting with at least one asterisk. All lines up to and including the asterisk line should be ignored.
    The first line after the asterisk line will consist of four numbers that define the "extent" of the figure. The numbers will be in this order: left, top, right, bottom.
    The next line will be the number of polylines in the figure.
    The rest of the file will be the list of polylines. Each polyline starts with a line that indicates the number of points in the polyline. Subsequent lines list the (x, y) pairs for each point.
For a point of comparison, here are the images that each of the example *.dat files generates: Project 1 Images

The picture should appear as soon as the user uploads a file. When the user uploads a new file, it replaces the old one.

Implementation notes:

    Be careful with how you pass parameters to the gl.viewport( ), ortho( ), and similar commands. Make sure you understand how they work!
    The "extent" line of the file will be used to set the world window.
    If you look at the vertex coordinates of some of the files, they are specified in floating point numbers, so please be sure you use the correct format for your variables.
    How you choose to ignore all lines up to and including the asterisk line is up to you.
    The format for dino.dat is a little different in that it doesn't have the window dimensions (or comments) right at the top. Therefore, off the bat, a program which reads other files without problems will have new problems with dino.dat file. You can either use a default extents window or come up with another solution that also works. Hint: a world window of (0,640,0,480) should work.
    The default drawing color is black.
    The background color should be white.
    The user does not need to be able to edit any of the files.
    All images should maintain their aspect ratio.

Part II: Draw Mode

When the user enters draw mode, your program clears the screen and presents a blank drawing area. On the first click in the drawing area, a dot is drawn at wherever the user clicked. On subsequent clicks, a line is drawn from the last accepted mouse click position to the current mouse click position. If the "b" key is held down while clicking, the current click point is NOT joined to the previous click point and instead a fresh polyline is started and drawn in addition to whatever previous polyline had been drawn.

Implementation notes:

    Your program should be set up to accept up to 100 possible mouse clicks in one polyline.
    You can accept and store user-provided points in an array.
    The default drawing color is black.
    The background color should be white.

Additional Requirements:

    The user should press "f" to enter File mode and "d" to enter draw mode.
    If the user presses "c", the color of the drawing on the screen cycles between black, red, green, and blue. For instance, if the current drawing color is black, hitting "c" redraws everything in red. Hitting "c" again redraws it in green, etc.
    Your canvas must always be large enough to be visible to the viewer but not so large that it extends beyond the edges of the browser window on a typical laptop display.
    You have some discretion over the interface design. However, it should be obvious to the user whether he or she is in draw or file mode. In addition, since this is not an HCI class, please keep the interface simple and legible.
    You should not use any deprecated commands.
    As this is a senior-level CS class, I expect your code to look clean and professional. This means following good coding practices such as proper indentation, basic refactoring, descriptive variable and function names, no large chunks of code that are commented out, etc. Make it something that you would be proud to post on GitHub.
    In the spirit of the previous point, please comment your code appropriately. Commenting helps us better understand what you're doing and why. There are no strict conventions that you are required to follow, but I recommend, at minimum, preceding each JavaScript function with an explanatory comment.
    You will need to include a documentation file (see "Submitting Your Work" below).
