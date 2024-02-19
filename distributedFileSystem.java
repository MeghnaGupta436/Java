package Feb16;
import java.util.HashMap;
import java.util.Map;

class File{ //class file
    private String fileName;
    private int fileSize;
    private boolean isReplicated;

    File(String name, int size, boolean replicated){ //constructor
        this.fileName = name;
        this.fileSize = size;
        this.isReplicated = replicated;
    }
    //getters and setters
    public String getFileName(){
        return fileName;
    }
    public int getFileSize(){
        return fileSize;
    }
    public boolean getReplicated(){
        return isReplicated;
    }
    public void setReplicated(boolean replicated){
        this.isReplicated = replicated;
    }
}

class DFSException extends Exception{ //derived class
    public DFSException(String message){
        super(message);
    }
}

class Server{ //class server
    private int serverId;
    Map<String , File> files;

    Server(int id){
        this.files = new HashMap<>();
    }

    public boolean fileExists(String fileName){
        if(files.containsKey(fileName)){
            return true;
        }
        return false;
    }
    public void uploadFile(File file){
        try{
            if(files.containsKey(file.getFileName())){
                throw new DFSException("File with the file Name : " + file.getFileName() + " already exists in the server..!!");
            }
            files.put(file.getFileName(), file);
        }catch (DFSException e){
            System.out.println(e.getMessage());
        }
    }
    public void downloadFile(String fileName){
        try{
            if(!files.containsKey(fileName)){
                throw new DFSException("File with the file name : " + fileName + " doesn't exist in the server..!!");
            }
            System.out.println("Downloading the file..!!");
            System.out.println("File Downloaded..!!");
        }catch (DFSException e){
            System.out.println(e.getMessage());
        }
    }

}
public class distributedFileSystem { //main class
    public static void main(String[] args){

    }
}

