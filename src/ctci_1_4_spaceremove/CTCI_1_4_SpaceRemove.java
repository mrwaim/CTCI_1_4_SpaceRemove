/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctci_1_4_spaceremove;

/**
 *
 * @author klsandbox
 */
public class CTCI_1_4_SpaceRemove {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(percentTwentySpace("hello world  "));
        System.out.println(percentTwentySpace("hello world    "));
        System.out.println(percentTwentySpace("hello  world    "));
        System.out.println(percentTwentySpace(" hello  world      "));
        System.out.println(percentTwentySpace(" hel lo  world        "));
    }
    
    public static String percentTwentySpace(String str) {
        char[] array = str.toCharArray();
        
        int spaces = 0;
        int nonSpacesIndex = -1;
        int firstSpaceIndex = -1;
        for (int ctr = array.length - 1; ctr >= 0; ctr--) {
            if (array[ctr] != ' ') {
                if (nonSpacesIndex == -1) {
                    nonSpacesIndex = ctr;
                }
            } else if (nonSpacesIndex != -1) {
                spaces++;
                firstSpaceIndex = ctr;
            }
        }
        
        for (int ctr = nonSpacesIndex; ctr >= firstSpaceIndex; ctr--) {
            System.out.println(new String(array));
            if (array[ctr] != ' ') {
                array[ctr + spaces * 2] = array[ctr];
            } else {
                array[ctr + spaces * 2] = '0';
                array[ctr + spaces * 2 - 1] = '2';
                array[ctr + spaces * 2 - 2] = '%';
                spaces--;
            }
        }
        
        return "<" + new String(array) + ">";
    }
    
}
