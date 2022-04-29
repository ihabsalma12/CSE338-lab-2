import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.testng.annotations.*;

import java.util.Vector;

import static org.junit.Assert.*;

public class WatchTest {
    Watch watch;
    //static Vector<String> //edgeTCs = new Vector<String>();


    @BeforeEach
    public void init(){
        watch = new Watch();
    }

    @Nested
    @DisplayName("Edge Testing")
    class EdgeTest{
        @Test
        public void EdgeTestNormal(){
            watch.takeInput('a');    //edgeTCs.add("a");

            assertEquals(watch.getState(), "NORMAL");
            assertEquals(watch.getState1(), "DATE");

            watch.takeInput('a');         //edgeTCs.add("a");

            assertEquals(watch.getState(), "NORMAL");
            assertEquals(watch.getState1(), "TIME");
        }
        @Test
        public void EdgeTestUpdate(){
            watch.takeInput('c'); //from normal to update
            //edgeTCs.add("c");

            watch.takeInput('b');
            //edgeTCs.add("b");

            assertEquals(watch.getState(), "UPDATE");
            assertEquals(watch.getState1(), "MIN");

            watch.takeInput('a');
            watch.takeInput('b');
            //edgeTCs.add("a");
            //edgeTCs.add("b");

            assertEquals(watch.getState(), "UPDATE");
            assertEquals(watch.getState1(), "HOUR");

            watch.takeInput('a');
            watch.takeInput('b');
            //edgeTCs.add("a");
            //edgeTCs.add("b");
            assertEquals(watch.getState(), "UPDATE");
            assertEquals(watch.getState1(), "DAY");

            watch.takeInput('a');
            watch.takeInput('b');
            //edgeTCs.add("a");
            //edgeTCs.add("b");
            assertEquals(watch.getState(), "UPDATE");
            assertEquals(watch.getState1(), "MONTH");

            watch.takeInput('a');
            watch.takeInput('b');
            //edgeTCs.add("a");
            //edgeTCs.add("b");
            assertEquals(watch.getState(), "UPDATE");
            assertEquals(watch.getState1(), "YEAR");

            watch.takeInput('a'); //exit update
            //edgeTCs.add("a");
            assertEquals(watch.getState(), "NORMAL");
            assertEquals(watch.getState1(), "TIME");

            watch.takeInput('c'); //to update
            //edgeTCs.add("c");
            assertEquals(watch.getState(), "UPDATE");
            assertEquals(watch.getState1(), "MIN");
            watch.takeInput('d'); //exit update
            //edgeTCs.add("d");
            assertEquals(watch.getState(), "NORMAL");
            assertEquals(watch.getState1(), "TIME");

            assertEquals(watch.getm(), new Integer(1));
            assertEquals(watch.geth(), new Integer(1));
            assertEquals(watch.getD(), new Integer(2));
            assertEquals(watch.getM(), new Integer(2));
            assertEquals(watch.getY(), new Integer(2001));

            System.out.print("\nDate: ");
            watch.displayDate();
            System.out.print("\nTime: ");
            watch.displayTime();
        }
        @Test
        public void EdgeTestAlarm(){
            watch.takeInput('b');             //edgeTCs.add("b");
            assertEquals(watch.getState(), "ALARM");
            assertEquals(watch.getState1(), "ALARM");
            watch.takeInput('a');            //edgeTCs.add("a");
            assertEquals(watch.getState(), "ALARM");
            assertEquals(watch.getState1(), "CHIME");
            watch.takeInput('d');            //edgeTCs.add("d");
            assertEquals(watch.getState(), "NORMAL");
            assertEquals(watch.getState1(), "TIME");
        }

        //TODO fix annot @Test
        //@Test
        //public void outputSuite(){
            //System.out.println("Edge Test Suite = "); //+ edgeTCs);
        //}
    }

    //define:
    //setNull method
    //setters
    //constructor (none to use associations here since it uses setters immediately)
    //takeInput
    //use:
    //takeInput

    //thus, all def-use =
    //1. setters to takeInput
    //2. setNull to takeInput
    //3. takeInput to takeInput

    @Nested
    @DisplayName("ADUP Testing")
    class ADUPTest{
        //TODO fix ADUPTCs [][] output
        //static Vector<Vector<String>> ADUPTCs = new Vector<Vector<String>>(3);
        //static int i = 0;
        @Test
        public void ADUP1(){
            //for(int i = 0; i < 3; i++) ADUPTCs.add(new Vector<String>(1));
            watch.takeInput('c'); //from normal to update
            //ADUPTCs.get(0).set(i, "c"); i++;

            watch.takeInput('b');
            //ADUPTCs.get(0).set(i, "b");            i++;

            assertEquals(watch.getState(), "UPDATE");
            assertEquals(watch.getState1(), "MIN");

            watch.takeInput('a');
            watch.takeInput('b');
            //ADUPTCs.get(0).set(i, "a");            i++;
            //ADUPTCs.get(0).set(i, "b");            i++;


            assertEquals(watch.getState(), "UPDATE");
            assertEquals(watch.getState1(), "HOUR");

            watch.takeInput('a');
            watch.takeInput('b');
            //ADUPTCs.get(0).set(i, "a");            i++;
            //ADUPTCs.get(0).set(i, "b");            i++;
            assertEquals(watch.getState(), "UPDATE");
            assertEquals(watch.getState1(), "DAY");

            watch.takeInput('a');
            watch.takeInput('b');
            //ADUPTCs.get(0).set(i, "a");            i++;
            //ADUPTCs.get(0).set(i, "b");            i++;
            assertEquals(watch.getState(), "UPDATE");
            assertEquals(watch.getState1(), "MONTH");

            watch.takeInput('a');
            watch.takeInput('b');
            //ADUPTCs.get(0).set(i, "a");            i++;
            //ADUPTCs.get(0).set(i, "b");            i++;
            assertEquals(watch.getState(), "UPDATE");
            assertEquals(watch.getState1(), "YEAR");


            assertEquals(watch.getm(), new Integer(1));
            assertEquals(watch.geth(), new Integer(1));
            assertEquals(watch.getD(), new Integer(2));
            assertEquals(watch.getM(), new Integer(2));
            assertEquals(watch.getY(), new Integer(2001));

            System.out.print("\nDate: ");
            watch.displayDate();
            System.out.print("\nTime: ");
            watch.displayTime();
        }
        @Test
        public void ADUP2(){
            watch.setNull();
            watch.setState("NORMAL");
            watch.setState1("TIME");
            watch.takeInput('c'); //from normal to update
            //ADUPTCs.get(0).set(i, "c");            i++;

            try {
                watch.takeInput('b');
            }
            catch(Exception e){
                System.out.println("\nADUP2 testing class: " +
                        "exception occurs when changing \"m\" value with the following message.");
                System.out.println(e.getMessage());
            }
            //ADUPTCs.get(0).set(i, "b");            i++;

            assertEquals(watch.getState(), "UPDATE");
            assertEquals(watch.getState1(), "MIN");
            try{
                watch.takeInput('a');
                watch.takeInput('b');
                //ADUPTCs.get(0).set(i, "a");            i++;
                //ADUPTCs.get(0).set(i, "b");            i++;
            }
            catch(Exception e){
                System.out.println("\nADUP2 testing class: " +
                        "exception occurs when changing \"h\" value with the following message.");
                System.out.println(e.getMessage());
            }
            assertEquals(watch.getState(), "UPDATE");
            assertEquals(watch.getState1(), "HOUR");


            try{
                watch.takeInput('a');
                watch.takeInput('b');
                //ADUPTCs.get(0).set(i, "a");            i++;
                //ADUPTCs.get(0).set(i, "b");            i++;
            }
            catch(Exception e){
                System.out.println("\nADUP2 testing class: " +
                        "exception occurs when changing \"D\" value with the following message.");
                System.out.println(e.getMessage());
            }
            assertEquals(watch.getState(), "UPDATE");
            assertEquals(watch.getState1(), "DAY");
            try{
                watch.takeInput('a');
                watch.takeInput('b');
                //ADUPTCs.get(0).set(i, "a");            i++;
                //ADUPTCs.get(0).set(i, "b");            i++;
            }
            catch(Exception e){
                System.out.println("\nADUP2 testing class: " +
                        "exception occurs when changing \"M\" value with the following message.");
                System.out.println(e.getMessage());
            }
            assertEquals(watch.getState(), "UPDATE");
            assertEquals(watch.getState1(), "MONTH");

            try{
                watch.takeInput('a');
                watch.takeInput('b');
            }
            catch(Exception e){
                System.out.println("\nADUP2 testing class: " +
                        "exception occurs when changing \"Y\" value with the following message.");
                System.out.println(e.getMessage());
            }

            //ADUPTCs.get(0).set(i, "a");            i++;
            //ADUPTCs.get(0).set(i, "b");            i++;
            assertEquals(watch.getState(), "UPDATE");
            assertEquals(watch.getState1(), "YEAR");


            assertEquals(watch.getm(), null);
            assertEquals(watch.geth(), null);
            assertEquals(watch.getD(), null);
            assertEquals(watch.getM(), null);
            assertEquals(watch.getY(), null);

            System.out.print("\nDate: ");
            watch.displayDate();
            System.out.print("\nTime: ");
            watch.displayTime();
        }
        @Test
        public void ADUP3(){
            watch.takeInput('c'); //from normal to update
            assertEquals(watch.getState(), "UPDATE");
            assertEquals(watch.getState1(), "MIN");
            watch.takeInput('b');
            watch.takeInput('b');


            watch.takeInput('a');
            assertEquals(watch.getState(), "UPDATE");
            assertEquals(watch.getState1(), "HOUR");
            watch.takeInput('b');
            watch.takeInput('b');


            watch.takeInput('a');
            assertEquals(watch.getState(), "UPDATE");
            assertEquals(watch.getState1(), "DAY");
            watch.takeInput('b');
            watch.takeInput('b');


            watch.takeInput('a');
            assertEquals(watch.getState(), "UPDATE");
            assertEquals(watch.getState1(), "MONTH");
            watch.takeInput('b');
            watch.takeInput('b');


            watch.takeInput('a');
            assertEquals(watch.getState(), "UPDATE");
            assertEquals(watch.getState1(), "YEAR");
            watch.takeInput('b');
            watch.takeInput('b');


            assertEquals(watch.getm(), new Integer(2));
            assertEquals(watch.geth(), new Integer(2));
            assertEquals(watch.getD(), new Integer(3));
            assertEquals(watch.getM(), new Integer(3));
            assertEquals(watch.getY(), new Integer(2002));

            System.out.print("\nDate: ");
            watch.displayDate();
            System.out.print("\nTime: ");
            watch.displayTime();
        }


    }

/*@AfterClass
        public static void outputSuites(){
            System.out.println("\nEdgeTest: {<input>, <state1>}" +
                    "\n{<\"a\", \"a\">, <\"DATE\", \"TIME\">;" +
                    "\n\"c\", \"b\", \"a\", \"b\", \"a\", \"b\", \"a\", \"b\", \"a\", \"b\", \"a\", \"c\", \"d\">, <\"MIN\", \"MIN\", \"HOUR\", \"HOUR\", \"DAY\", \"DAY\", \"MONTH\", \"MONTH\", \"YEAR\", \"YEAR\", \"TIME\", \"MIN\", \"TIME\">;" +
                    "\n<\"b\", \"a\", \"d\">, <\"ALARM\", \"CHIME\", \"TIME\">}" +


                    "ADUPTest: {<input>, <state1>}" +
                    "\n{<\"c\", \"b\", \"a\", \"b\", \"a\", \"b\", \"a\", \"b\", \"a\", \"b\">, <\"MIN\", \"MIN\", \"HOUR\", \"HOUR\", \"DAY\", \"DAY\", \"MONTH\", \"MONTH\", \"YEAR\", \"YEAR\">;" +
                    "\n<\"c\", \"b\", \"a\", \"b\", \"a\", \"b\", \"a\", \"b\", \"a\", \"b\">, <\"MIN\", \"MIN\", \"HOUR\", \"HOUR\", \"DAY\", \"DAY\", \"MONTH\", \"MONTH\", \"YEAR\", \"YEAR\">;" +
                    "\n<\"c\", \"b\", \"b\", \"a\", \"b\", \"b\", \"a\", \"b\", \"b\", \"a\", \"b\", \"b\", \"b\", \"a\", \"b\", \"b\", \"b\">, <\"MIN\", \"MIN\", \"MIN\", \"HOUR\", \"HOUR\", \"HOUR\", \"DAY\", \"DAY\", \"DAY\", \"MONTH\", \"MONTH\", \"MONTH\", \"YEAR\", \"YEAR\", \"YEAR\">}");
        }*/
/*EdgeTest: {<input>, <state1>}

{<"a", "a">, <"DATE", "TIME">;
"c", "b", "a", "b", "a", "b", "a", "b", "a", "b", "a", "c", "d">, <"MIN", "MIN", "HOUR", "HOUR", "DAY", "DAY", "MONTH", "MONTH", "YEAR", "YEAR", "TIME", "MIN", "TIME">;
<"b", "a", "d">, <"ALARM", "CHIME", "TIME">}


ADUPTest: {<input>, <state1>}
{<"c", "b", "a", "b", "a", "b", "a", "b", "a", "b">, <"MIN", "MIN", "HOUR", "HOUR", "DAY", "DAY", "MONTH", "MONTH", "YEAR", "YEAR">;
<"c", "b", "a", "b", "a", "b", "a", "b", "a", "b">, <"MIN", "MIN", "HOUR", "HOUR", "DAY", "DAY", "MONTH", "MONTH", "YEAR", "YEAR">;
<"c", "b", "b", "a", "b", "b", "a", "b", "b", "a", "b", "b", "b", "a", "b", "b", "b">, <"MIN", "MIN", "MIN", "HOUR", "HOUR", "HOUR", "DAY", "DAY", "DAY", "MONTH", "MONTH", "MONTH", "YEAR", "YEAR", "YEAR">}*/
    @AfterEach
    public void cleanUp(){
        watch.setNull();
        watch = null;
    }

}