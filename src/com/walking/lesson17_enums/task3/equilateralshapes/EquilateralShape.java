package com.walking.lesson17_enums.task3.equilateralshapes;

public enum EquilateralShape {
	
	EQUILATERAL_TRIANGLE(8) {
		public final String TRIANGLE_HORIZONTAL_SIDE_ELEMENT = "--";
		public final String TRIANGLE_LEFT_SIDE_ELEMENT = "/";
		public final String TRIANGLE_RIGHT_SIDE_ELEMENT = "\\";
		
		@Override
		public String createShapeString() {
			String triangle = EMPTY_STRING;
			
			for (int i = 0; i < this.getLength(); i++) {
				for (int j = 0; j < this.getLength() - i; j++) {
					triangle += EMPTY_ELEMENT;
				}
				
				triangle += TRIANGLE_LEFT_SIDE_ELEMENT;
				
				for (int j = 0; j < i * 2; j++) {
					triangle += EMPTY_ELEMENT;
				}
				
				triangle += TRIANGLE_RIGHT_SIDE_ELEMENT + NEW_LINE_SYMBOL;
			}
			
			triangle += " ";
			
			for (int i = 0; i < this.getLength(); i++) {
				triangle += TRIANGLE_HORIZONTAL_SIDE_ELEMENT;
			}
			
			return triangle;
		}
	},
	
	EQUILATERAL_SHAPE(8) {
		public final String RECTANGLE_HORIZONTAL_ELEMENT = "-";
		public final String RECTANGLE_VERTICAL_ELEMENT = "|";
		
		@Override
		public String createShapeString() {
			String horizontalLine = createHorizontalLine(this.getLength());
			String verticalLines = createVerticalLines(this.getLength());
			
			return horizontalLine + verticalLines + horizontalLine;
		}
		
		private String createHorizontalLine(int length) {
			String horizontalLine = EMPTY_ELEMENT;
			
			for (int i = 0; i < length; i++) {
				horizontalLine += RECTANGLE_HORIZONTAL_ELEMENT;
			}
			
			horizontalLine += EMPTY_ELEMENT + NEW_LINE_SYMBOL;
			
			return horizontalLine;
		}
		
		private String createVerticalLines(int length) {
			String verticalLinesUnit = getVerticalLinesUnit(length);
			
			String verticalLines = EMPTY_STRING;
			
			for (int i = 0; i < length; i++) {
				verticalLines += verticalLinesUnit;
			}
			
			return verticalLines;
		}
		
		private String getVerticalLinesUnit(int length) {
			String verticalLinesUnit = RECTANGLE_VERTICAL_ELEMENT;
			
			for (int i = 0; i < length; i++) {
				verticalLinesUnit += EMPTY_ELEMENT;
			}
			
			verticalLinesUnit += RECTANGLE_VERTICAL_ELEMENT + NEW_LINE_SYMBOL;
			
			return verticalLinesUnit;
		}
	};
	
	public static final String EMPTY_ELEMENT = " ";
	public static final String EMPTY_STRING = "";
	public static final char NEW_LINE_SYMBOL = '\n';
	private final int length;
	
	
	EquilateralShape(int length) {
		this.length = length;
	}
	
	public int getLength() {
		return length;
	}
	
	public abstract String createShapeString();
}
