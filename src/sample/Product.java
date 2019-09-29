package sample;

abstract class Product implements Item {
  private int id;
  private  String type;
  private String manufacturer;
  private String name;

  public int getId(){
    return id;
  }
  public void setName(String name){
    this.name = name;
  }
  public String getName(){
    return name;
  }
  public void setManufacturer(String manufacturer){
    this.manufacturer = manufacturer;
  }
  public String getManufacturer() {
    return manufacturer;
  }
  Product(String name){
    this.name = name;
  }
  public String toString(){
    return "Name: "+name+"%nManufacturer: "+manufacturer+"%nType: "+type;
  }
}
