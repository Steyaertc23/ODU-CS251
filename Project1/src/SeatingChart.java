public class SeatingChart {
    /**
     * Extracts the row and column indices from the given seat ID.
     *
     * @param seatID The seat ID in the format [LETTERS][DIGITS].
     * @return An int array containing the row and column indices.
     */
    public static int[] rowColumnIndexFromSeatID(String seatID) {
        String digits = seatID.replaceAll("[^0-9]", "");
        String letters = seatID.replaceAll("[^A-Za-z]", "");

        int rowValue = 0;
        for (int i = 0; i < letters.length(); i++) {
            rowValue = rowValue * 26 + (letters.charAt(i) - 'A' + 1);
        }

        int columnValue = Integer.parseInt(digits);

        return new int[]{rowValue - 1, columnValue - 1};
    }

    /**
     * Generates a seat ID from the given row and column indices.
     *
     * @param row The row index, where 0 represents the first row.
     * @param column The column index, where 0 represents the first column.
     * @return The seat ID in the format [LETTERS][DIGITS].
     */
    public static String seatIDFromRowColumnIndex(int row, int column)
    {
        StringBuilder rowString = new StringBuilder("");
        while (row >= 0) {
            rowString.insert(0, (char) ('A' + (row % 26)));
            row = (row / 26) - 1;
        }
        return rowString.append(column + 1).toString();
    }
}