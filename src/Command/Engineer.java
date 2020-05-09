package Command;

//Invoker
public class Engineer {
    private ICommand _command;
    public Engineer(ICommand command){
        this._command = command;
    }
    public void resetSensors(){
        _command.execute();
    }
}
