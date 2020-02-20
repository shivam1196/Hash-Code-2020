class Library{
    private int noOfBooks;
    private int signUpDays;
    private int booksDispatchedPerDay;
    private long calculatedScore;

    public int getNoOfBooks() {
        return noOfBooks;
    }

    public void setNoOfBooks(int noOfBooks) {
        this.noOfBooks = noOfBooks;
    }

    public int getSignUpDays() {
        return signUpDays;
    }

    public void setSignUpDays(int signUpDays) {
        this.signUpDays = signUpDays;
    }

    public int getBooksDispatchedPerDay() {
        return booksDispatchedPerDay;
    }

    public void setBooksDispatchedPerDay(int booksDispatchedPerDay) {
        this.booksDispatchedPerDay = booksDispatchedPerDay;
    }

    public long getCalculatedScore() {
        return calculatedScore;
    }

    public void setCalculatedScore(long calculatedScore) {
        this.calculatedScore = calculatedScore;
    }
}