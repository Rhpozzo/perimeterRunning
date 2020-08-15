import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        //Start with totalPoints = 0
        int totalPoints = 0;
        //Iterate over the points given and add 1 to total points if any stop when you run out of points. 
        for(Point currPt : s.getPoints()){  
            totalPoints = totalPoints + 1;     
        }
        return totalPoints;
    }

    public double getAverageLength(Shape s) {
        // set a double variable. 
        double avgLen = 0.0;  
        //set variable to getPerimeter(s);
        double getperim = getPerimeter(s);
        //set double variable to the amount of points; 
        double points = getNumPoints(s); 
        //update avgLen to the division of getperim/points to get average length. 
        avgLen = getperim/points; 
        //return avgLen is the answer. 
        return avgLen; 
       
    }

    public double getLargestSide(Shape s) {
        // set a double variable to update as largestSide
        double largestSide = 0.0; 
        Point prevPt = s.getLastPoint(); 
        //Determine which is the largestside of the points. 
        for(Point larSide : s.getPoints()){ 
            double currDist = prevPt.distance(larSide); 
            if(currDist > largestSide){
                largestSide = currDist; 
            }
            
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        //delcare a double variable
        double largestX = 0.0; 
        //loop through the points to find the biggest x with getX(); 
        for(Point bigX : s.getPoints()){
            //declare a double that looks for the current x of bigX; 
            double currX = bigX.getX(); 
            //if currX is bigger than largestX your answer is largestX is CurrX; 
            if(currX > largestX){
                largestX = currX;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // use the Directory Resource to select multiple files.
        DirectoryResource dr = new DirectoryResource();
        // Double to hold largest perim. 
        double larPerim = 0.0; 
        //loop to go thourgh the selected files. 
        for(File f : dr.selectedFiles()){
            //Make a new file resource.
            FileResource fr = new FileResource(f); 
            // Creates a new shape. 
            Shape s = new Shape(fr);
            //Get current perimeter of current file.
            double currPerim = getPerimeter(s); 
            //Conditional to determine which of the perimeter is the biggest. 
            if(currPerim > larPerim){
                larPerim = currPerim; 
            }
 
        }
        return larPerim;
    }

    public String getFileWithLargestPerimeter() {
        //Finish writing the method getFileWithLargestPerimeter that has no parameters. 
        //This method should, like the getLargestPerimeterMultipleFiles method,
        //create its own Directory Resource, except that this new method returns
        //the File that has the largest such perimeter,so it has return type File.
        double largestPerim = 0.0; 
        File temp = null;
        DirectoryResource dr = new DirectoryResource();
             //replace this code
        for(File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerim = getPerimeter(s);
            if(currPerim > largestPerim){
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        
        int points = getNumPoints(s);
        System.out.println("There are " + points + " points"); 
        
        
        double averageLength = getAverageLength(s);
        
        System.out.println("The average length is " + averageLength); 
        
        double largest = getLargestSide(s);
        System.out.println("This is the largest side " + largest); 
        
        double bigX = getLargestX(s);
        System.out.println("This is the largest X in the points " + bigX); 
        
        
    }
    
        public void testPerimeterMultipleFiles() {
        // 2. Finish writing the void method testPerimeterMultipleFiles to 
        //call getLargestPerimeterMultipleFiles and to print out the 
        //largest such perimeter. 
        //This method has no parameters and no return value. 
        //You will select the files when you run this method 
        //(hint: see our documentation for the DirectoryResource class).
        double largestMultiFilePerim = getLargestPerimeterMultipleFiles();
        System.out.println("Current largest perim " + largestMultiFilePerim); 
          
    }

    
    public void testFileWithLargestPerimeter() {
        //Add code to the method testFileWithLargestPerimeter 
        //to call getFileWithLargestPerimeter. 
        //For the File that is returned, print the name of that file.
        String largest = getFileWithLargestPerimeter(); 
        
        System.out.println("This is largest" + largest); 
        
    }

    
    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
    }

        public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
