import java.io.*;
import java.util.*;

import com.sun.org.apache.xerces.internal.xs.StringList;
import org.junit.*;
import static org.junit.Assert.*;

public class DistinctStringListTest {
    private DistinctStringList sut;

    public DistinctStringListTest() throws IOException, NoSuchMethodException {
        if(sut == null) {
            sut = new DistinctStringList();
            System.out.println("SUT: " + sut.getClass().getName());
        }
    }

    @Test(timeout = 1_000) public void addDifferent() {
        // arrange
        sut = new DistinctStringList();
        ArrayList<String> want = new ArrayList<String>();
        // act
        sut.add("abra");
        sut.add("kadabra");
        DistinctStringList have = sut;
        want.add("abra");
        want.add("kadabra");
        // assert
        Assert.assertEquals(want, have);
    }

    @Test(timeout = 1_000, expected = IllegalArgumentException.class) public void addEqualTwice() {
        // arrange
        sut = new DistinctStringList();
        ArrayList<String> want = new ArrayList<String>();
        // act
        sut.add("abra");
        sut.add("abra");
        DistinctStringList have = sut;
        want.add("abra");
        // assert
        Assert.assertEquals(want, have);
    }

    @Test(timeout = 1_000, expected = IllegalArgumentException.class) public void addNullTwice() {
        // arrange
        sut = new DistinctStringList();
        ArrayList<String> want = new ArrayList<String>();
        // act
        sut.add(null);
        sut.add(null);
        DistinctStringList have = sut;
        want.add(null);
        want.add(null);
        // assert
        Assert.assertEquals(want, have);
    }

    @Test(timeout = 1_000) public void addAtNewString() {
        // arrange
        sut = new DistinctStringList();
        ArrayList<String> want = new ArrayList<String>();
        // act
        sut.add(0, "abra");
        DistinctStringList have = sut;
        want.add(0, "abra");
        // assert
        Assert.assertEquals(want, have);
    }

    @Test(timeout = 1_000, expected = IllegalArgumentException.class) public void addAtContainedString() {
        // arrange
        sut = new DistinctStringList();
        ArrayList<String> want = new ArrayList<String>();
        // act
        sut.add("abra");
        sut.add(sut.get(0));
        DistinctStringList have = sut;
        want.add("abra");
        want.add(want.get(0));
        // assert
        Assert.assertEquals(want, have);
    }

    @Test(timeout = 1_000) public void setNewString() {
        // arrange
        sut = new DistinctStringList();
        ArrayList<String> want = new ArrayList<String>();
        // act
        sut.add("abra");
        sut.set(0,"kadabra");
        DistinctStringList have = sut;
        want.add("abra");
        want.set(0, "kadabra");
        // assert
        Assert.assertEquals(want, have);
    }

    @Test(timeout = 1_000, expected = IllegalArgumentException.class) public void setContainedString() {
        // arrange
        sut = new DistinctStringList();
        ArrayList<String> want = new ArrayList<String>();
        // act
        sut.set(0,"abra");
        sut.set(1,sut.get(0));
        DistinctStringList have = sut;
        want.set(0, "abra");
        want.set(1, want.get(0));
        // assert
        Assert.assertEquals(want, have);
    }

    @Test(timeout = 1_000) public void setSameStringAgain() {
        // arrange
        sut = new DistinctStringList();
        ArrayList<String> want = new ArrayList<String>();
        // act
        sut.add("abra");
        sut.set(0,"kadabra");
        sut.set(0,"abra");
        DistinctStringList have = sut;
        want.add("abra");
        want.set(0, "kadabra");
        want.set(0, "abra");
        // assert
        Assert.assertEquals(want, have);
    }

    @Test(timeout = 1_000, expected = NullPointerException.class) public void addAllNull() {
        // arrange
        sut = new DistinctStringList();
        ArrayList<String> want = new ArrayList<String>();
        // act
        sut.addAll(null);
        DistinctStringList have = sut;
        want.addAll(null);
        // assert
        Assert.assertEquals(want, have);
    }

    @Test(timeout = 1_000) public void addAllEmpty() {
        // arrange
        sut = new DistinctStringList();
        ArrayList<String> want = new ArrayList<String>();
        // act
        sut.addAll(new DistinctStringList());
        DistinctStringList have = sut;
        want.addAll(new ArrayList<String>());
        // assert
        Assert.assertEquals(want, have);
    }

    @Test(timeout = 1_000) public void addAllDifferent() {
        // arrange
        sut = new DistinctStringList();
        ArrayList<String> want = new ArrayList<String>();
        // act
        DistinctStringList newList = new DistinctStringList();
        sut.add("yo");
        newList.add("abra");
        newList.add("kadabra");
        sut.addAll(newList);
        DistinctStringList have = sut;
        want.add("yo");
        want.addAll(newList);
        // assert
        Assert.assertEquals(want, have);
    }

    @Test(timeout = 1_000, expected = IllegalArgumentException.class) public void addAllContained() {
        // arrange
        sut = new DistinctStringList();
        ArrayList<String> want = new ArrayList<String>();
        // act
        sut.add("abra");
        sut.add("kadabra");
        sut.add("hans");
        DistinctStringList newList = new DistinctStringList();
        newList.add("abra");
        newList.add("kadabra");
        sut.addAll(newList);
        DistinctStringList have = sut;
        want.add("abra");
        want.add("kadabra");
        want.add("hans");
        // assert
        Assert.assertEquals(want, have);
    }

    @Test(timeout = 1_000, expected = IllegalArgumentException.class) public void addAllDoublettes() {
        // arrange
        sut = new DistinctStringList();
        ArrayList<String> want = new ArrayList<String>();
        // act
        DistinctStringList newList = new DistinctStringList();
        newList.add("abra");
        newList.add("kadabra");
        sut.addAll(newList);
        sut.addAll(newList);
        DistinctStringList have = sut;
        want.addAll(newList);
        want.addAll(newList);
        // assert
        Assert.assertEquals(want, have);
    }
}
