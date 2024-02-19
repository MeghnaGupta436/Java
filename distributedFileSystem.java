package Feb16;
import java.rmi.ServerError;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class File{
    private String fileName;
    private int fileSize;
    private boolean isReplicated;

    File(String name, int size){
        this.fileName = name;
        this.fileSize = size;
        this.isReplicated = false;
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

class DFSException extends Exception{
    public DFSException(String message){
        super(message);
    }
}

class Server{

    //    distributedFileSystem ob = new distributedFileSystem();
    private int serverId;
    private int serverSpace;
    Map<String , File> files;

    Server(int id, int space){
        this.serverId = id;
        this.serverSpace = space;
        this.files = new HashMap<>();
    }

    public int getServerId(){
        return serverId;
    }
    public int getServerSpace(){
        return serverSpace;
    }

    public void setServerSpace(int space){
        this.serverSpace = space;
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
            } else if (serverSpace < file.getFileSize()) {
                throw new DFSException("Not enough space available int the server : " + getServerSpace());
            }
            setServerSpace(getServerSpace() - file.getFileSize());
            files.put(file.getFileName(), file);
            distributedFileSystem.allFiles.put(file.getFileName(), file);
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
    public void replicateFile(File file, Server destinationServer){
        try{
            if(files.containsKey(file.getFileName())){
                throw new DFSException("No file with the file name " + file.getFileName() + " exist in thr source server " + getServerId());
            }
            else if(destinationServer.files.containsKey(file.getFileName())){
                throw new DFSException("File with the file Name : " + file.getFileName() + " already exists in the server : " + destinationServer.getServerId());
            } else if (destinationServer.getServerSpace() < file.getFileSize()) {
                throw new DFSException("Not enough space available int the server : " + destinationServer.getServerId());
            }
            file.setReplicated(true);
            setServerSpace(getServerSpace() - file.getFileSize());
            files.put(file.getFileName(), file);
            destinationServer.files.put(file.getFileName(), file);
        }catch (DFSException e){
            System.out.println(e.getMessage());
        }
    }
}
class DFSsystem{
    Map<Integer, Server> servers;
//    distributedFileSystem ob = new distributedFileSystem();

    DFSsystem(){
        this.servers = new HashMap<>();
    }

    public void addServer(Server server){
        try{
            if(servers.containsKey(server.getServerId())){
                throw new DFSException("Server with the server id: " + server.getServerId() + " already exist..!!");
            }
            servers.put(server.getServerId(), server);
            System.out.println("Server added successfully...!!");
        }catch (DFSException e){
            System.out.println(e.getMessage());
        }
    }

    public void uploadFile(File file, Server server){
        try{
            if(!servers.containsKey(server.getServerId())){
                throw new DFSException("No server found with server id : " + server.getServerId() + " ...!!!");
            } else if (server.files.containsKey(file.getFileName())) {
                throw new DFSException("File already exist in the server...!!1");
            } else if (server.getServerSpace() < file.getFileSize()) {
                throw new DFSException("There's no space in the server..!!");
            }
            server.setServerSpace(server.getServerSpace() - file.getFileSize());
            server.files.put(file.getFileName(), file);
            distributedFileSystem.allFiles.put(file.getFileName(), file);
        }catch (DFSException e){
            System.out.println(e.getMessage());
        }
    }
    public void downloadFile(String fileName, Server server){
        try{
            if(!server.files.containsKey(fileName)){
                throw new DFSException("File with the file name : " + fileName + " doesn't exist in the server..!!");
            }
            System.out.println("Downloading the file..!!");
            System.out.println("File Downloaded..!!");
        }catch (DFSException e){
            System.out.println(e.getMessage());
        }
    }
    public void replicateFile(File file, Server sourceServer, Server destinationServer){
        try{
            if(!sourceServer.files.containsKey(file.getFileName())){
                throw new DFSException("No file with the file name " + file.getFileName() + " exist in thr source server " + sourceServer.getServerId());
            }
            else if(destinationServer.files.containsKey(file.getFileName())){
                throw new DFSException("File withe the file name " + file.getFileName() + " already exist in the destination server " + destinationServer.getServerId());
            } else if (destinationServer.getServerSpace() < file.getFileSize()) {
                throw new DFSException("Not enough space available int the server : " + destinationServer.getServerId());
            }
            file.setReplicated(true);
            destinationServer.setServerSpace(destinationServer.getServerSpace() - file.getFileSize());
            sourceServer.files.put(file.getFileName(), file);
            destinationServer.files.put(file.getFileName(), file);
        }catch (DFSException e){
            System.out.println(e.getMessage());
        }
    }
}
public  class distributedFileSystem {

    Scanner sc = new Scanner(System.in);
    DFSsystem dfs = new DFSsystem();
    static Map<String, File> allFiles = new HashMap<>();

//    distributedFileSystem(){
////        this.all
//    }

    public void mainMenu(){
        System.out.println("Welcome to distributed file system...!!");
        System.out.println("1.Add a server");
        System.out.println("2.Upload a file");
        System.out.println("3.Download a file");
        System.out.println("4.Replicate file");
        System.out.println("5.Calculate free space");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                System.out.println("Enter server Id : ");
                int id = sc.nextInt();
                System.out.println("Enter Server space : ");
                int space = sc.nextInt();
                Server s = new Server(id, space);
                dfs.addServer(s);
                System.out.println("1.Check for a file in the server");
                System.out.println("2.Upload a file ");
                System.out.println("3.Download a file");
                System.out.println("4.Replicate a file");
                int choiceServer = sc.nextInt();
                switch (choiceServer){
                    case 1:
                        System.out.println("Enter file name : ");
                        String fileName = sc.next();
                        System.out.println("File exist in the server : " + s.fileExists(fileName));
                        break;
                    case 2:
                        System.out.println("Enter file name : ");
                        String name = sc.next();
                        System.out.println("Enter file size : ");
                        int size = sc.nextInt();
                        File file = new File(name, size);
                        s.uploadFile(file);
                        break;
                    case 3:
                        System.out.println("Enter file name : ");
                        String downName = sc.next();
                        s.downloadFile(downName);
                        break;
                    case 4:
                        System.out.println("Enter File name : ");
                        String repName = sc.next();
                        System.out.println("Enter Server Id : ");
                        int serverId = sc.nextInt();
                        s.replicateFile(allFiles.get(repName), dfs.servers.get(serverId));
                        break;
                    default:
                        System.out.println("Invalid input...!! ");
                        break;
//                        mainMenu();
                }
                mainMenu();
            case 2:
                System.out.println("Enter file name : ");
                String name = sc.next();
                System.out.println("Enter file size : ");
                int size = sc.nextInt();
                File file = new File(name, size);
                System.out.println("Enter Server Id: ");
                int serverId = sc.nextInt();
                dfs.uploadFile(file, dfs.servers.get(serverId));
                break;
            case 3:
                System.out.println("Enter file name : ");
                String dowName = sc.next();
                System.out.println("Enter Server Id: ");
                int downId = sc.nextInt();
                dfs.downloadFile(dowName, dfs.servers.get(downId));
                break;
            case 4:
                System.out.println("Enter File name : ");
                String repName = sc.next();
                System.out.println("Enter Source Server Id : ");
                int sourceServerId = sc.nextInt();
                System.out.println("Enter Source Server Id : ");
                int destinationServerId = sc.nextInt();
                dfs.replicateFile(allFiles.get(repName), dfs.servers.get(sourceServerId), dfs.servers.get(destinationServerId));
                break;
            case 5:
                System.out.println("Enter server id:");
                int spaceId = sc.nextInt();
                Server server = dfs.servers.get(spaceId);
                System.out.println("Free spcae in the server : " + server.getServerSpace());
                break;
            default:
                System.out.println("Invalid input...!! ");
//                mainMenu();
                break;
        }
        mainMenu();
    }
    public static void main(String[] args){
        distributedFileSystem d = new distributedFileSystem();
        d.sc.useDelimiter("\\n");
        d.mainMenu();
    }
}

