import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeClassifierTest {

    /**
     * Example Test
     */
    @DisplayName("Example Test")
    @Test
    public void example() {
        ShapeClassifier s = new ShapeClassifier();
        String answer = s.evaluateGuess("Equilateral,Large,Yes,100,100,100");
        assertNotEquals("Yes", answer);
    }

    /**
     * Boundary Value Analysis (BVA) Test Cases
     */
    @DisplayName("BVA - Valid Equilateral Triangle")
    @Test
    public void testBvaValidEquilateralTriangle() {
        ShapeClassifier s = new ShapeClassifier();
        String answer = s.evaluateGuess("Equilateral,Small,Yes,5,5,5");
        assertEquals("Equilateral", answer, "Should classify as Equilateral Triangle");
    }

    @DisplayName("BVA - Invalid Negative Sides")
    @Test
    public void testBvaInvalidNegativeSides() {
        ShapeClassifier s = new ShapeClassifier();
        String answer = s.evaluateGuess("Equilateral,Small,Yes,-5,-5,-5");
        assertEquals("Invalid", answer, "Should classify as Invalid for negative sides");
    }

    @DisplayName("BVA - Large Triangle Boundary")
    @Test
    public void testBvaLargeTriangleBoundary() {
        ShapeClassifier s = new ShapeClassifier();
        String answer = s.evaluateGuess("Equilateral,Large,Yes,100,100,100");
        assertEquals("Equilateral", answer, "Should classify as Equilateral Triangle");
    }

    /**
     * Equivalence Class Partitioning (ECP) Test Cases
     */
    @DisplayName("ECP - Valid Isosceles Triangle")
    @Test
    public void testEcpValidIsoscelesTriangle() {
        ShapeClassifier s = new ShapeClassifier();
        String answer = s.evaluateGuess("Isosceles,Medium,No,10,10,5");
        assertEquals("Isosceles", answer, "Should classify as Isosceles Triangle");
    }

    @DisplayName("ECP - Invalid Non-Triangle")
    @Test
    public void testEcpInvalidNonTriangle() {
        ShapeClassifier s = new ShapeClassifier();
        String answer = s.evaluateGuess("NonTriangle,Medium,No,10,5,2");
        assertEquals("Invalid", answer, "Should classify as Invalid for non-triangle inputs");
    }

    @DisplayName("ECP - Scalene Triangle")
    @Test
    public void testEcpScaleneTriangle() {
        ShapeClassifier s = new ShapeClassifier();
        String answer = s.evaluateGuess("Scalene,Medium,No,10,8,6");
        assertEquals("Scalene", answer, "Should classify as Scalene Triangle");
    }
}
