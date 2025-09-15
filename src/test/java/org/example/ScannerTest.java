package org.example;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.*;

class ScannerTest {
    @Test
    public void test1() throws IOException {

        String s = "var score123";
        StringReader sr = new StringReader(s);
        Scanner scanObj = new Scanner(new PushbackReader(sr));

        Scanner.TOKEN testA = scanObj.scan();
        assertEquals(Scanner.TOKEN.VAR, testA);

        Scanner.TOKEN testB = scanObj.scan();
        assertEquals(Scanner.TOKEN.ID, testB);
        assertEquals("score123", scanObj.getTokenBufferString());

        Scanner.TOKEN testC = scanObj.scan();
        assertEquals(Scanner.TOKEN.SCANEOF, testC);

    }
    @Test
    public void test2() throws IOException {
        String s = "init score = 600";
        StringReader sr = new StringReader(s);
        Scanner scanObj = new Scanner(new PushbackReader(sr));

        Scanner.TOKEN testA = scanObj.scan();
        assertEquals(Scanner.TOKEN.INIT, testA);

        Scanner.TOKEN testB = scanObj.scan();
        assertEquals(Scanner.TOKEN.ID, testB);
        assertEquals("score", scanObj.getTokenBufferString());

        Scanner.TOKEN testC = scanObj.scan();
        assertEquals(Scanner.TOKEN.EQUALS, testC);

        Scanner.TOKEN testD = scanObj.scan();
        assertEquals(Scanner.TOKEN.INTLITERAL, testD);
        assertEquals("600", scanObj.getTokenBufferString());


        Scanner.TOKEN testE = scanObj.scan();
        assertEquals(Scanner.TOKEN.SCANEOF, testE);
    }

    @Test
    public void test3() throws IOException {
        String s = "calculate newsalary = originalsalary + raise";
        StringReader sr = new StringReader(s);
        Scanner scanObj = new Scanner(new PushbackReader(sr));

        Scanner.TOKEN testA = scanObj.scan();
        assertEquals(Scanner.TOKEN.CALCULATE, testA);

        Scanner.TOKEN testB = scanObj.scan();
        assertEquals(Scanner.TOKEN.ID, testB);
        assertEquals("newsalary", scanObj.getTokenBufferString());

        Scanner.TOKEN testC = scanObj.scan();
        assertEquals(Scanner.TOKEN.EQUALS, testC);

        Scanner.TOKEN testD = scanObj.scan();
        assertEquals(Scanner.TOKEN.ID, testD);
        assertEquals("originalsalary", scanObj.getTokenBufferString());

        Scanner.TOKEN testE = scanObj.scan();
        assertEquals(Scanner.TOKEN.PLUS, testE);


        Scanner.TOKEN testF = scanObj.scan();
        assertEquals(Scanner.TOKEN.ID, testF);
        assertEquals("raise", scanObj.getTokenBufferString());

        Scanner.TOKEN testG = scanObj.scan();
        assertEquals(Scanner.TOKEN.SCANEOF, testG);
    }
    @Test
    public void test4() throws IOException {
        String s = "write salary";
        StringReader sr = new StringReader(s);
        Scanner scanObj = new Scanner(new PushbackReader(sr));

        Scanner.TOKEN testA = scanObj.scan();
        assertEquals(Scanner.TOKEN.WRITE, testA);

        Scanner.TOKEN testB = scanObj.scan();
        assertEquals(Scanner.TOKEN.ID, testB);
        assertEquals("salary", scanObj.getTokenBufferString());

        Scanner.TOKEN testC = scanObj.scan();
        assertEquals(Scanner.TOKEN.SCANEOF, testC);

    }
    @Test
    public void test5() throws IOException {
        String s = "if x = y then endif";
        StringReader sr = new StringReader(s);
        Scanner scanObj = new Scanner(new PushbackReader(sr));

        Scanner.TOKEN testA = scanObj.scan();
        assertEquals(Scanner.TOKEN.IF, testA);

        Scanner.TOKEN testB = scanObj.scan();
        assertEquals(Scanner.TOKEN.ID, testB);
        assertEquals("x", scanObj.getTokenBufferString());

        Scanner.TOKEN testC = scanObj.scan();
        assertEquals(Scanner.TOKEN.EQUALS, testC);

        Scanner.TOKEN testD = scanObj.scan();
        assertEquals(Scanner.TOKEN.ID, testD);
        assertEquals("y", scanObj.getTokenBufferString());

        Scanner.TOKEN testE = scanObj.scan();
        assertEquals(Scanner.TOKEN.THEN, testE);

        Scanner.TOKEN testF = scanObj.scan();
        assertEquals(Scanner.TOKEN.ENDIF, testF);

        Scanner.TOKEN testG = scanObj.scan();
        assertEquals(Scanner.TOKEN.SCANEOF, testG);
    }
    @Test
    public void test6() throws IOException {
        String s = "if x = y then write x endif";
        StringReader sr = new StringReader(s);
        Scanner scanObj = new Scanner(new PushbackReader(sr));

        Scanner.TOKEN testA = scanObj.scan();
        assertEquals(Scanner.TOKEN.IF, testA);

        Scanner.TOKEN testB = scanObj.scan();
        assertEquals(Scanner.TOKEN.ID, testB);
        assertEquals("x", scanObj.getTokenBufferString());

        Scanner.TOKEN testC = scanObj.scan();
        assertEquals(Scanner.TOKEN.EQUALS, testC);

        Scanner.TOKEN testD = scanObj.scan();
        assertEquals(Scanner.TOKEN.ID, testD);
        assertEquals("y", scanObj.getTokenBufferString());

        Scanner.TOKEN testE = scanObj.scan();
        assertEquals(Scanner.TOKEN.THEN, testE);

        Scanner.TOKEN testF = scanObj.scan();
        assertEquals(Scanner.TOKEN.WRITE, testF);

        Scanner.TOKEN testG = scanObj.scan();
        assertEquals(Scanner.TOKEN.ID, testG);
        assertEquals("x", scanObj.getTokenBufferString());

        Scanner.TOKEN testH = scanObj.scan();
        assertEquals(Scanner.TOKEN.ENDIF, testH);

        Scanner.TOKEN testJ = scanObj.scan();
        assertEquals(Scanner.TOKEN.SCANEOF, testJ);
    }
    @Test
    public void test7() throws IOException {
        String s = "while x != y do calculate x = x + 1 endwhile";
        StringReader sr = new StringReader(s);
        Scanner scanObj = new Scanner(new PushbackReader(sr));

        Scanner.TOKEN testA = scanObj.scan();
        assertEquals(Scanner.TOKEN.WHILE, testA);

        Scanner.TOKEN testB = scanObj.scan();
        assertEquals(Scanner.TOKEN.ID, testB);
        assertEquals("x", scanObj.getTokenBufferString());

        Scanner.TOKEN testC = scanObj.scan();
        assertEquals(Scanner.TOKEN.NOTEQUALS, testC);

        Scanner.TOKEN testD = scanObj.scan();
        assertEquals(Scanner.TOKEN.ID, testD);
        assertEquals("y", scanObj.getTokenBufferString());

        Scanner.TOKEN testE = scanObj.scan();
        assertEquals(Scanner.TOKEN.DO, testE);

        Scanner.TOKEN testF = scanObj.scan();
        assertEquals(Scanner.TOKEN.CALCULATE, testF);

        Scanner.TOKEN testG = scanObj.scan();
        assertEquals(Scanner.TOKEN.ID, testG);
        assertEquals("x", scanObj.getTokenBufferString());

        Scanner.TOKEN testH = scanObj.scan();
        assertEquals(Scanner.TOKEN.EQUALS, testH);

        Scanner.TOKEN testI = scanObj.scan();
        assertEquals(Scanner.TOKEN.ID, testI);
        assertEquals("x", scanObj.getTokenBufferString());

        Scanner.TOKEN testJ = scanObj.scan();
        assertEquals(Scanner.TOKEN.PLUS, testJ);

        Scanner.TOKEN testK = scanObj.scan();
        assertEquals(Scanner.TOKEN.INTLITERAL, testK);
        assertEquals("1", scanObj.getTokenBufferString());

        Scanner.TOKEN testL = scanObj.scan();
        assertEquals(Scanner.TOKEN.ENDWHILE, testL);

        Scanner.TOKEN testM = scanObj.scan();
        assertEquals(Scanner.TOKEN.SCANEOF, testM);

    }
    @Test
    public void test8() throws IOException {
        String s = "";
        StringReader sr = new StringReader(s);
        Scanner scanObj = new Scanner(new PushbackReader(sr));
        Scanner.TOKEN testA = scanObj.scan();
        assertEquals(Scanner.TOKEN.SCANEOF, testA);
    }
    //Made a test to check input with unique spacing
    @Test
    public void test9() throws IOException {
        String s = " Num100+10!=110 ";
        StringReader sr = new StringReader(s);
        Scanner scanObj = new Scanner(new PushbackReader(sr));
        Scanner.TOKEN testA = scanObj.scan();
        assertEquals(Scanner.TOKEN.ID, testA);
        assertEquals("Num100", scanObj.getTokenBufferString());

        Scanner.TOKEN testB = scanObj.scan();
        assertEquals(Scanner.TOKEN.PLUS, testB);

        Scanner.TOKEN testC = scanObj.scan();
        assertEquals(Scanner.TOKEN.INTLITERAL, testC);
        assertEquals("10", scanObj.getTokenBufferString());

        Scanner.TOKEN testD = scanObj.scan();
        assertEquals(Scanner.TOKEN.NOTEQUALS, testD);

        Scanner.TOKEN testE = scanObj.scan();
        assertEquals(Scanner.TOKEN.INTLITERAL, testE);
        assertEquals("110", scanObj.getTokenBufferString());

    }

}
