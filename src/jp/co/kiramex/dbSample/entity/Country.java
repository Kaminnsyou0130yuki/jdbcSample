package jp.co.kiramex.dbSample.entity;

public class Country {
//    DTOクラスは操作対象のテーブルの数だけ作成することになる。
//    複数個になっても管理がしやすいようにDTO専用パッケージに配置するとよい。
    private String name;
    private int population;

    public Country(){

    }

    public Country(String name, int population) {
        this.name = name;
        this.population = population;
    }

//    name getter/setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
//    population getter/setter
        public int getPopulation() {
        return population;
    }
    public void setPopulation(int population) {
        this.population = population;
    }
}
