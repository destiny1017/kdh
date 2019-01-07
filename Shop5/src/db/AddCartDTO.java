package db;

public class AddCartDTO {
   private String uId;
   private String pId;
   private String size;
   private String count;

   public String getuId() {
      return uId;
   }

   public void setuId(String uId) {
      this.uId = uId;
   }

   public String getpId() {
      return pId;
   }

   public void setpId(String pId) {
      this.pId = pId;
   }

   public String getSize() {
      return size;
   }

   public void setSize(String size) {
      this.size = size;
   }

   public String getCount() {
      return count;
   }

   public void setCount(String count) {
      this.count = count;
   }

}