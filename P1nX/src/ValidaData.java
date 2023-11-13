public class ValidaData {
    public boolean isDia(int day){
        if(day<32 && day>0) return true;
        return false;
    }

    public boolean isMes(int month){
        if(month>0 && month<13) return true;
        return false;
    }
    public boolean isAno(int year){
        if(year > 0) return true;

        return false;
    }
    public boolean isDia(String day){
        if(isDia(Integer.parseInt(day))) return true;
        return false;
    }

    public boolean isMes(String month){
        if(isMes(Integer.parseInt(month))) return true;
        return false;
    }
    public boolean isAno(String year){
        if(isAno(Integer.parseInt(year))) return true;
        return false;
    }
}
