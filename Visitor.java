public interface Visitor {

    void visitFilteredResult(FilterResult fr);
    void visitConcert(Concert c);
    void visitWorkshop(Workshop w);
    void visitGala(Gala g);
    void visitScreening(Screening s);

    void visitFestival(Festival f);
}
