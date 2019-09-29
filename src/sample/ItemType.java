package sample;

public enum ItemType {
  AUDIO,
  VISUAL,
  AUDIO_MOBILE,
  VISUAL_MOBILE;
  public String code;
  ItemType(){
    switch(this.toString()){
      case "AUDIO":
        code = "AU";
        break;
      case "VISUAL":
        code = "VI";
        break;
      case "AUDIO_MOBILE":
        code = "AM";
        break;
      case "VISUAL_MOBILE":
        code = "VM";
        break;
    }
  }
}