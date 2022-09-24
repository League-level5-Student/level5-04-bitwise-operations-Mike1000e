package _03_Printing_Binary;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Goal: Create a program that converts a binary string to ascii, decimal,
 *       and hexadecimal.
 * 
 * Programmers sometimes use a number system called hexadecimal that has 16
 * different possible characters per digit. Each digit can be from 0 to F,
 *     hex character: 0  1  2  3  4  5  6  7  8  9  A  B  C  D  E  F
 *     decimal value: 0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15
 * 
 * Hex values are prefixed with a 0x in code,
 *      int hex = 0x1F;     // 31 decimal, 11111 binary
 * 
 * Since each hex digit can be 16 different characters, 1 byte can be expressed
 * as 2 hex characters. All 3 int variables below are the same value.
 *      int hex = 0x1F;
 *      int bin = 0b11111;
 *      int dec = 31;
 * 
 * Hex is used because it is more compact than binary. For example,
 *      int bin = 0b11111111111111111111111111111111    // 32 1s
 *      int hex = 0xFFFFFFFF;       // 8 F characters
 * 
 * Complete the methods so that it displays the correct hex value,.
 * decimal value, and ASCII value, if applicable.
 */
public class _02_HexadecimalPrinter implements ActionListener {
    JFrame frame;
    JPanel panel;
    JTextField hexResult, decimalResult, asciiResult, inputTextField;
    JLabel labelAscii, labelDecimal, labelHex;
    JButton convertButton;

    /*
     * Complete these 3 methods. Assume the binary value is an int (32 bits).
     * You don't have to handle negative numbers unless you want the challenge!
     */
    String binaryToHex(String binaryStr) {
    	String returned = " ";
    	
    	char[] four = new char[4];
    	int countfour = 4;
    	char[] charray = binaryStr.toCharArray();
    	
    	for(int i = charray.length-1; i>=0; i--) {
    		
    		if(!(countfour==0)) {
    			System.out.println(four[countfour-1]);
    			four[countfour-1] = charray[i];
    			System.out.println(four[countfour-1]);

    			countfour--;
    		}else {
    			//converting
    			int convert = 0;
    	    	int numberAmount = four.length;
    	    	int highest = 1;
    	    	for(int j = four.length-1; j>=0 ;j--) {
    	    		
    	    		if(four[j] == '1' ) {
    	    			convert = convert+highest;
    	    		}
    	    		highest = highest*2;
    	    	}
    	    	
    	    	String adding = "";  
    	    	adding = convert + "";
    			if(convert ==10 ) {
    				adding = "A"; 
    				}else if (convert ==11) {
    					adding = "B";
    				}else if (convert ==12) {
    					adding = "C";
    				}else if (convert ==13) {
    					adding = "D";
    				}else if (convert ==14) {
    					adding = "E";
    				}else if (convert ==15) {
    					adding = "F";
    				}
    		//convert done
    			
    			//adding should be converted to hex

    			returned = adding + returned;
    			System.out.println(returned);
    			countfour = 4;
    			
    			System.out.println(four[countfour-1]);
    			four[countfour-1] = charray[i];
    			System.out.println(four[countfour-1]);

    			countfour--;
    		}
    		if(i==0) {
    			
    			int convert = 0;
    	    	int numberAmount = four.length;
    	    	int highest = 1;
    	    	for(int j = four.length-1; j>=0 ;j--) {
    	    		
    	    		if(four[j] == '1' ) {
    	    			convert = convert+highest;
    	    		}
    	    		highest = highest*2;
    	    	}
    	    	
    	    	String adding = "";  
    	    	adding = convert + "";
    			if(convert ==10 ) {
    				adding = "A"; 
    				}else if (convert ==11) {
    					adding = "B";
    				}else if (convert ==12) {
    					adding = "C";
    				}else if (convert ==13) {
    					adding = "D";
    				}else if (convert ==14) {
    					adding = "E";
    				}else if (convert ==15) {
    					adding = "F";
    				}
    		//convert done
    			
    			//adding should be converted to hex

    			//adding should be converted to hex
    		
    			returned = adding + returned;
    			System.out.println(returned);
    			countfour = 4;
    			
    		}
    	}
    	
        return "0x" + returned;
        
    }
    
    
    
    
    
    
    
    String binaryToDec(String binaryStr) {
    	int convert = 0;
    	int numberAmount = binaryStr.length();
    	int highest = 1;
    	char[] array  = binaryStr.toCharArray();
    	for(int i = array.length-1; i>=0 ;i--) {
    		int countDown = array.length;
    	
    		
    		
    		
    		if(array[i] == '1' ) {
    			convert = convert+highest;
    		}
    		highest = highest*2;
    	}
    	
		return convert + "";
    }
       
    

    /*
     * ASCII values are exactly 8 bits so return '-' if there isn't.
     */
    String binaryToAscii(String binaryStr) {
        if (binaryStr.length() != 8) {
            return "-";
        }

        return "-";
    }
    
    public static void main(String[] args) {
        new _02_HexadecimalPrinter().start();
    }

    public void start() {
        frame = new JFrame("Hexadecimal Printer");
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        hexResult = new JTextField(12);
        decimalResult = new JTextField(12);
        asciiResult = new JTextField(12);
        inputTextField = new JTextField(25);
        convertButton = new JButton("Convert");
        labelAscii = new JLabel("ASCII:");
        labelDecimal = new JLabel("Decimal:");
        labelHex = new JLabel("Hexadecimal:");
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        
        labelAscii.setFont(new Font("Arial", Font.PLAIN, 30));
        labelDecimal.setFont(new Font("Arial", Font.PLAIN, 30));
        labelHex.setFont(new Font("Arial", Font.PLAIN, 30));
        inputTextField.setFont(new Font("Arial", Font.PLAIN, 30));
        decimalResult.setFont(new Font("Arial", Font.PLAIN, 30));
        asciiResult.setFont(new Font("Arial", Font.PLAIN, 30));
        hexResult.setFont(new Font("Arial", Font.PLAIN, 30));
        convertButton.setFont(new Font("Arial", Font.PLAIN, 30));
        convertButton.addActionListener(this);
        
        inputTextField.setText("<Input binary number>");
        inputTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) { }
            
            @Override
            public void focusGained(FocusEvent e) {
                if( inputTextField.getText().contains("binary") ) {
                    inputTextField.setText("");
                }
            }
        });
        
        addObjectToPanel(inputTextField, 0, 0, 2);
        addObjectToPanel(convertButton, 1, 0, 2);
        addObjectToPanel(labelAscii, 2, 0, 1);
        addObjectToPanel(asciiResult, 2, 1, 1);
        addObjectToPanel(labelDecimal, 3, 0, 1);
        addObjectToPanel(decimalResult, 3, 1, 1);
        addObjectToPanel(labelHex, 4, 0, 1);
        addObjectToPanel(hexResult, 4, 1, 1);
        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // 18. If convertButton was pressed...
        JButton buttonPressed = (JButton) e.getSource();
        if( buttonPressed == convertButton) {
            String binaryStr = inputTextField.getText();
            
            String asciiStr = binaryToAscii(binaryStr);
            String decimalStr = binaryToDec(binaryStr);
            String hexStr = binaryToHex(binaryStr);
            
            asciiResult.setText(asciiStr);
            decimalResult.setText(decimalStr);
            hexResult.setText(hexStr);
        }
    }

    private void addObjectToPanel(JComponent component, int row, int column, int cellWidth) {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;       // This expands the JComponent to fill gridwidth
        constraints.gridx = column;             // This is the column the JComponent is placed
        constraints.gridy = row;                // This is the row the JComponent is placed
        constraints.gridwidth = cellWidth;      // This is how many horizontal cells to span across
        constraints.gridheight = 1;             // This is how many vertical cells to span across
        this.panel.add(component, constraints);
    }
}
