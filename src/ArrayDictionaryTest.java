import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDictionaryTest {
    @Test
    public void demo() {
        int testSize = 5;
        ArrayDictionary dict = new ArrayDictionary(testSize);
        assertTrue(dict.add(2, 82));
        assertTrue(dict.add(4, 84));
        assertTrue(dict.add(7, 87));
        System.out.println(dict);
    }

    @Test
    public void remove() {
        KVEntry[] inputs = new KVEntry[5];
        inputs[0] = new KVEntry(0,103);
        inputs[1] = new KVEntry(1,105);
        inputs[2] = new KVEntry(2,206);
        inputs[3] = new KVEntry(4,407);
        inputs[4] = new KVEntry(8,407);

        int[] loop = {0,1,2,4,4,4};
        ArrayDictionary[] sets = new ArrayDictionary[6];
        for(int i = 0; i < sets.length; i++){
            sets[i] = new ArrayDictionary(loop[i]);
        }

        int[] counter = {0,3,2,5,5,5};

        for(int j = 1; j < 5; j++){
            for(int i = 0; i < counter[j]; i++){
                if(inputs[i] != null){
                    sets[j].add(inputs[i].key,inputs[i].value);
                }
            }
        }

        int[] input = {1,1,8,4,1,9};
        boolean[] result = {false,true,false,true,true,false};

        for(int i = 0; i < input.length; i++){
            assertEquals(result[i],sets[i].remove(input[i]));
        }

    }
    @Test
    public void contains() {

        KVEntry[] inputs = new KVEntry[4];
        inputs[0] = new KVEntry(0,103);
        inputs[1] = new KVEntry(1,105);
        inputs[2] = new KVEntry(2,206);
        inputs[3] = new KVEntry(4,407);

        int[] loop = {0,1,2,3,3};
        ArrayDictionary[] sets = new ArrayDictionary[5];
        for(int i = 0; i < sets.length; i++){
            sets[i] = new ArrayDictionary(loop[i]);
        }

        int[] counter = {0,1,2,3,4};

        for(int j = 1; j < 5; j++){
            for(int i = 0; i < counter[j]; i++){
                if(inputs[i] != null){
                    sets[j].add(inputs[i].key,inputs[i].value);
                }
            }
        }

        int[][] input = {{-1,0,1},{2,0},{0,1,2,3},{3,1},{1,4,7,8}};
        boolean[][] result = {{false,false,false},{false,true},{true,true,false,false},{false,true},{true,true,false,false}};

        for(int j = 0; j < 5; j++){
            for(int i = 0; i < input[j].length; i++){
                assertEquals(result[j][i],sets[j].contains(input[j][i]));
            }
        }
    }
}