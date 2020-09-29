package cz.yb.jetpackdemo.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LiveDataViewModel extends ViewModel {
    private MutableLiveData<Integer> ticketCxk;
    private  MutableLiveData<Integer> ticketJay ;

    public MutableLiveData<Integer> getTicketCxk() {
        if(ticketCxk == null){
            ticketCxk = new MutableLiveData<>();
            ticketCxk.setValue(0);
        }
        return ticketCxk;
    }

    public MutableLiveData<Integer> getTicketJay() {
        if(ticketJay == null){
            ticketJay = new MutableLiveData<>();
            ticketJay.setValue(0);
        }
        return ticketJay;
    }

    public  void addJay(){
        if(ticketJay.getValue() !=null) {
            ticketJay.setValue(ticketJay.getValue() + 1);
        }
    }

    public  void addCxk(){
        if(ticketCxk.getValue() !=null) {
            ticketCxk.setValue(ticketCxk.getValue() + 1);
        }
    }
}
