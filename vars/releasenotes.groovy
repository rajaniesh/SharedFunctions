import java.io.File;
import groovy.io.FileType;

def call(Map config=[:]){
    def dir = new File(pwd());
    
    echo "******************" + dir.path + "******************";
    
    new File(dir.path + '\\releasenotes.txt').withWriter('utf-8') { 
        writer -> 
            dir.eachFileRecurse(FileType.ANY){ file ->
                if (file.isDirectory()){
                    writer.writeLine(file.name);            
                }
                else
                {
                    writer.writeLine('\t' + file.name + '\t' + file.length());
                }
        } 
    }
}