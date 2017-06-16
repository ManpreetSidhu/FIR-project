/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conn;

import bean.Category;
import bean.CheckFir;
import bean.Complain1;
import bean.Missing;
import bean.Online_fir;
import bean.Registeration;
import bean.Show1;
import bean.Suggestion;
import bean.Wanted;
import bean.infoacc;
import bean.thought;
import bean.whatsnew;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import newpackage.Register_servlet;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
import sun.awt.geom.AreaOp;

/**
 *
 * @author sidhu
 */
public class DBoperation {
     public boolean insertSuggestion(Suggestion s)
    {
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("insert into suggestion(Name,Phone_no,Email,City,Address,Suggestion_sub,Suggestion_detail)values(?,?,?,?,?,?,?)");
        ps.setString(1,s.getName());
        ps.setString(2,s.getPhone_no());
        ps.setString(3,s.getEmail());
        ps.setString(4,s.getCity());
        ps.setString(5,s.getAddress());
        ps.setString(6,s.getSuggestion_sub());
        ps.setString(7,s.getSuggestion_detail());
        int i=ps.executeUpdate();
        if(i>0)
            return true;
        }
        catch(Exception e){
            System.out.println("Exception in insertSuggestion "+e);
        }
        return false;
    }
        public boolean insertComplain(Complain1 cp)
    {
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("insert into complaint(Name,Phone_no,Email,City,Address,Complaint_sub,Complaint_detail)values(?,?,?,?,?,?,?)");
        ps.setString(1,cp.getName());
        ps.setString(2,cp.getPhone_no());
        ps.setString(3,cp.getEmail());
        ps.setString(4,cp.getCity());
        ps.setString(5,cp.getAddress());
        ps.setString(6,cp.getComplain_sub());
        ps.setString(7,cp.getComplain_detail());
        int i=ps.executeUpdate();
        if(i>0)
            return true;
        }
        catch(Exception e){
            System.out.println("Exception in insertComplain "+e);
        }
        return false;
    }
   
       public boolean insertRegis(Registeration r)
    {
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("insert into registeration(F_name,L_name,Username,Password,Confirm_pas,Gender,B_month,B_day,B_year,Mobile_no,Email,Security_q,Security_a,Location,Terms)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1,r.getF_name());
        ps.setString(2,r.getL_name());
        ps.setString(3,r.getUsername());
        ps.setString(4,r.getPassword());
        ps.setString(5,r.getConfirm_pas());
        ps.setString(6,r.getGender());
        ps.setString(7,r.getB_month());
        ps.setString(8,r.getB_day());
        ps.setString(9,r.getB_year());
        ps.setString(10,r.getMobile_no());
        ps.setString(11,r.getEmail());
        ps.setString(12,r.getSecurity_q());
        ps.setString(13,r.getSecurity_a());
        ps.setString(14,r.getLocation());
        ps.setString(15,r.getTerms());
        int i=ps.executeUpdate();
        if(i>0)
            return true;
        }
        catch(Exception e){
            System.out.println("Exception in insertFir "+e);
        }
        return false;
    }
            public boolean checkLogin(Registeration ub)
    {
        
         try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("select * from registeration");
        
       ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
           String un=rs.getString(4).trim();
            String pas=rs.getString(5).trim();
           if( un.equals(ub.getUsername())&&pas.equals(ub.getPassword()))
           {
               return true;
           }
           
       }}
        catch(Exception e){
            System.out.println("Exception in login "+e);
        }
        return false;
    }
   
             public boolean Infoacc(infoacc a1)
    {
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("insert into infoacc(Fir_no,Fir_sub,Police_Station,Year,Date,Accident_place,Victim_no,Vehicle_no,Rank,Officer_name)values(?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1,a1.getFir_no());
        ps.setString(2,a1.getFir_sub());
        ps.setString(3,a1.getPolice_Station());
        ps.setString(4,a1.getYear());
        ps.setString(5,a1.getDate());
        ps.setString(6,a1.getAccident_place());
        ps.setString(7,a1.getVictim_no());
        ps.setString(8,a1.getVehicle_no());
        ps.setString(9,a1.getRank());
        ps.setString(10,a1.getOfficer_name());
      
        int i=ps.executeUpdate();
        if(i>0)
            return true;
        }
        catch(Exception e){
            System.out.println("Exception in insertFir "+e);
        }
        return false;
    }
    public boolean insertFir(Online_fir f1)
     {
    
        String pos=f1.getPolice_station();
        if(pos.equals("Amritsar Police Station")){
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("insert into amritsar_ps(Topic,Description,App_name,Phone_no,Email,App_add,Police_station,Id_proof,Proof_no,Name,Address)values(?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1,f1.getTopic());
        ps.setString(2,f1.getDescription());
        ps.setString(3,f1.getApp_name());
        ps.setString(4,f1.getPhone_no());
        ps.setString(5,f1.getEmail());
        ps.setString(6,f1.getApp_add());
        ps.setString(7,f1.getPolice_station());
        ps.setString(8,f1.getId_proof());
        ps.setString(9,f1.getProof_no());
        ps.setString(10,f1.getName());
        ps.setString(11,f1.getAddress());
        int i=ps.executeUpdate();
        if(i>0)
            return true;
        }
        catch(Exception e){
            System.out.println("Exception in insertFir "+e);
        }
       
        }
        else  if(pos.equals("Barnala Police Station")){
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("insert into barnala_ps(Topic,Description,App_name,Phone_no,Email,App_add,Police_station,Id_proof,Proof_no,Name,Address)values(?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1,f1.getTopic());
        ps.setString(2,f1.getDescription());
        ps.setString(3,f1.getApp_name());
        ps.setString(4,f1.getPhone_no());
        ps.setString(5,f1.getEmail());
        ps.setString(6,f1.getApp_add());
        ps.setString(7,f1.getPolice_station());
        ps.setString(8,f1.getId_proof());
        ps.setString(9,f1.getProof_no());
        ps.setString(10,f1.getName());
        ps.setString(11,f1.getAddress());
        int i=ps.executeUpdate();
        if(i>0)
            return true;
        }
        catch(Exception e){
            System.out.println("Exception in insertFir "+e);
        }
       
        }
        else   if(pos.equals("Bathinda Police Station")){
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("insert into bathinda_ps(Topic,Description,App_name,Phone_no,Email,App_add,Police_station,Id_proof,Proof_no,Name,Address)values(?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1,f1.getTopic());
        ps.setString(2,f1.getDescription());
        ps.setString(3,f1.getApp_name());
        ps.setString(4,f1.getPhone_no());
        ps.setString(5,f1.getEmail());
        ps.setString(6,f1.getApp_add());
        ps.setString(7,f1.getPolice_station());
        ps.setString(8,f1.getId_proof());
        ps.setString(9,f1.getProof_no());
        ps.setString(10,f1.getName());
        ps.setString(11,f1.getAddress());
        int i=ps.executeUpdate();
        if(i>0)
            return true;
        }
        catch(Exception e){
            System.out.println("Exception in insertFir "+e);
        }
       
        }
        else   if(pos.equals("Faridkot Police Station")){
         try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("insert into faridkot_ps(Topic,Description,App_name,Phone_no,Email,App_add,Police_station,Id_proof,Proof_no,Name,Address)values(?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1,f1.getTopic());
        ps.setString(2,f1.getDescription());
        ps.setString(3,f1.getApp_name());
        ps.setString(4,f1.getPhone_no());
        ps.setString(5,f1.getEmail());
        ps.setString(6,f1.getApp_add());
        ps.setString(7,f1.getPolice_station());
        ps.setString(8,f1.getId_proof());
        ps.setString(9,f1.getProof_no());
        ps.setString(10,f1.getName());
        ps.setString(11,f1.getAddress());
        int i=ps.executeUpdate();
        if(i>0)
            return true;
        }
        catch(Exception e){
            System.out.println("Exception in insertFir "+e);
        }
       
        }
        else   if(pos.equals("Fazilka Police Station")){
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("insert into fazilka_ps(Topic,Description,App_name,Phone_no,Email,App_add,Police_station,Id_proof,Proof_no,Name,Address)values(?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1,f1.getTopic());
        ps.setString(2,f1.getDescription());
        ps.setString(3,f1.getApp_name());
        ps.setString(4,f1.getPhone_no());
        ps.setString(5,f1.getEmail());
        ps.setString(6,f1.getApp_add());
        ps.setString(7,f1.getPolice_station());
        ps.setString(8,f1.getId_proof());
        ps.setString(9,f1.getProof_no());
        ps.setString(10,f1.getName());
        ps.setString(11,f1.getAddress());
        int i=ps.executeUpdate();
        if(i>0)
            return true;
        }
        catch(Exception e){
            System.out.println("Exception in insertFir "+e);
        }
       
        }
        else   if(pos.equals("Jalandhar Police Station")){
      try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("insert into jalandhar_ps(Topic,Description,App_name,Phone_no,Email,App_add,Police_station,Id_proof,Proof_no,Name,Address)values(?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1,f1.getTopic());
        ps.setString(2,f1.getDescription());
        ps.setString(3,f1.getApp_name());
        ps.setString(4,f1.getPhone_no());
        ps.setString(5,f1.getEmail());
        ps.setString(6,f1.getApp_add());
        ps.setString(7,f1.getPolice_station());
        ps.setString(8,f1.getId_proof());
        ps.setString(9,f1.getProof_no());
        ps.setString(10,f1.getName());
        ps.setString(11,f1.getAddress());
        int i=ps.executeUpdate();
        if(i>0)
            return true;
        }
        catch(Exception e){
            System.out.println("Exception in insertFir "+e);
        }
       
        }
        else   if(pos.equals("Ludhiana Police Station")){
      try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("insert into ludhiana_ps(Topic,Description,App_name,Phone_no,Email,App_add,Police_station,Id_proof,Proof_no,Name,Address)values(?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1,f1.getTopic());
        ps.setString(2,f1.getDescription());
        ps.setString(3,f1.getApp_name());
        ps.setString(4,f1.getPhone_no());
        ps.setString(5,f1.getEmail());
        ps.setString(6,f1.getApp_add());
        ps.setString(7,f1.getPolice_station());
        ps.setString(8,f1.getId_proof());
        ps.setString(9,f1.getProof_no());
        ps.setString(10,f1.getName());
        ps.setString(11,f1.getAddress());
        int i=ps.executeUpdate();
        if(i>0)
            return true;
        }
        catch(Exception e){
            System.out.println("Exception in insertFir "+e);
        }
       
        }
        else   if(pos.equals("Sangrur Police Station")){
            
       
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("insert into sangrur_ps(Topic,Description,App_name,Phone_no,Email,App_add,Police_station,Id_proof,Proof_no,Name,Address)values(?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1,f1.getTopic());
        ps.setString(2,f1.getDescription());
        ps.setString(3,f1.getApp_name());
        ps.setString(4,f1.getPhone_no());
        ps.setString(5,f1.getEmail());
        ps.setString(6,f1.getApp_add());
        ps.setString(7,f1.getPolice_station());
        ps.setString(8,f1.getId_proof());
        ps.setString(9,f1.getProof_no());
        ps.setString(10,f1.getName());
        ps.setString(11,f1.getAddress());
        int i=ps.executeUpdate();
        if(i>0)
            return true;
        }
        catch(Exception e){
            System.out.println("Exception in insertFir "+e);
        }
       
        }
         return false;
}
  
public ArrayList retriveinfo( String city){
    ArrayList al=new ArrayList();
      System.out.println(city);
 
     try {
        
           if(city.equals("Amritsar Police Station"))  {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
             PreparedStatement ps = con.prepareStatement("select * from amritsar_ps");

             ResultSet rs = ps.executeQuery();

             while (rs.next()) {
                 Show1 s = new Show1();
                 int fir = rs.getInt(1);
                 String ps1 = rs.getString(8);
                 String status = rs.getString(15);
                 String off = rs.getString(13);
                 String rank = rs.getString(14);
                 s.setFir_no(fir);
                 s.setPolice_Station(ps1);
                 s.setStatus(status);
                 s.setOfficer(off);
                 s.setRank(rank);
                 al.add(s);
             }
         }
             else  if(city.equals("Barnala Police Station"))  {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
             PreparedStatement ps = con.prepareStatement("select * from barnala_ps");

             ResultSet rs = ps.executeQuery();

             while (rs.next()) {
                 Show1 s = new Show1();
                 int fir = rs.getInt(1);
                 String ps1 = rs.getString(8);
                 String status = rs.getString(15);
                 String off = rs.getString(13);
                 String rank = rs.getString(14);
                 s.setFir_no(fir);
                 s.setPolice_Station(ps1);
                 s.setStatus(status);
                 s.setOfficer(off);
                 s.setRank(rank);
                 al.add(s);
             }
         }
             else if(city.equals("Bathinda Police Station"))  {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("select * from bathinda_ps");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Show1 s = new Show1();
                int fir = rs.getInt(1);
                String ps1 = rs.getString(8);
                String status = rs.getString(15);
                String off = rs.getString(13);
                String rank = rs.getString(14);
                s.setFir_no(fir);
                s.setPolice_Station(ps1);
                s.setStatus(status);
                s.setOfficer(off);
                s.setRank(rank);
                al.add(s);
            }
        }
            else if(city.equals("Faridkot Police Station"))  {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("select * from faridkot_ps");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Show1 s = new Show1();
                int fir = rs.getInt(1);
                String ps1 = rs.getString(8);
                String status = rs.getString(15);
                String off = rs.getString(13);
                String rank = rs.getString(14);
                s.setFir_no(fir);
                s.setPolice_Station(ps1);
                s.setStatus(status);
                s.setOfficer(off);
                s.setRank(rank);
                al.add(s);
            }
        }
            else if(city.equals("Fazilka Police Station"))  {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("select * from fazilka_ps");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Show1 s = new Show1();
                int fir = rs.getInt(1);
                String ps1 = rs.getString(8);
                String status = rs.getString(15);
                String off = rs.getString(13);
                String rank = rs.getString(14);
                s.setFir_no(fir);
                s.setPolice_Station(ps1);
                s.setStatus(status);
                s.setOfficer(off);
                s.setRank(rank);
                al.add(s);
            }
        }
            else if(city.equals("Ludhiana Police Station"))  {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("select * from ludhiana_ps");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Show1 s = new Show1();
                int fir = rs.getInt(1);
                String ps1 = rs.getString(8);
                String status = rs.getString(15);
                String off = rs.getString(13);
                String rank = rs.getString(14);
                s.setFir_no(fir);
                s.setPolice_Station(ps1);
                s.setStatus(status);
                s.setOfficer(off);
                s.setRank(rank);
                al.add(s);
            }
        }
            else if(city.equals("Sangrur Police Station"))  {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("select * from sangrur_ps");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Show1 s = new Show1();
                int fir = rs.getInt(1);
                String ps1 = rs.getString(8);
                String status = rs.getString(15);
                String off = rs.getString(13);
                String rank = rs.getString(14);
                s.setFir_no(fir);
                s.setPolice_Station(ps1);
                s.setStatus(status);
                s.setOfficer(off);
                s.setRank(rank);
                al.add(s);
            }
        }
            else if(city.equals("Jalandhar Police Station"))  {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("select * from jalandhar_ps");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Show1 s = new Show1();
                int fir = rs.getInt(1);
                String ps1 = rs.getString(8);
                String status = rs.getString(15);
                String off = rs.getString(13);
                String rank = rs.getString(14);
                s.setFir_no(fir);
                s.setPolice_Station(ps1);
                s.setStatus(status);
                s.setOfficer(off);
                s.setRank(rank);
                al.add(s);
            }
        }
    }
     catch(Exception e){
         System.out.println(" "+e);}


return al;
}

    public boolean insertinfo(infoacc a1)
    {
        try{
           
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps=con.prepareStatement
                ("insert into infoacc(Fir_no,Fir_sub,Police_Station,Year,Date,Accident_place,Victim_no,Vehicle_no,Rank,Officer_Name)values(?,?,?,?,?,?,?,?,?,?)");
       

            ps.setInt(1, a1.getFir_no());
            ps.setString(2, a1.getFir_sub());
            ps.setString(3, a1.getPolice_Station());
            ps.setString(4, a1.getYear());
            ps.setString(5, a1.getDate());
            ps.setString(6, a1.getAccident_place());
            ps.setString(7, a1.getVictim_no());
            ps.setString(8, a1.getVehicle_no());
            ps.setString(9, a1.getRank());
            ps.setString(10,a1.getOfficer_name());
      int i=ps.executeUpdate();
        if(i>0)
            return true;
        }
        catch(Exception e){
            System.out.println("Exception in insertwanted "+e);
        }
        return false;
    } 
    
    public boolean checkFir(CheckFir c1){
   String pos=c1.getPolice_Station();
        System.out.println(pos);String st="";
 if(pos.equals("Amritsar Police Station")){
     try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("select * from amritsar_ps");
       ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            if(rs.getInt(1)==(c1.getFirNo()))
           {st=rs.getString(15);
               return true;
           }
        }
     }
    catch(Exception e)
     {
         System.out.println("Exception in check Fir"+e);
     }}
 else if(pos.equals("Barnala Police Station")){
     try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("select * from barnala_ps");
      ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            if(rs.getInt(1)==(c1.getFirNo()))
           {
               return true;
           }}
    }
    catch(Exception e)
     {
         System.out.println("Exception in check Fir"+e);
     }}
 else if(pos.equals("Bathinda Police Station")){
     try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("select * from bathinda_ps");
        
       ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            if(rs.getInt(1)==(c1.getFirNo()))
           {
               return true;
           }}}
     catch(Exception e)
     {
         System.out.println("Exception in check Fir"+e);
     }}
 else if(pos.equals("Faridkot Police Station")){
     try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("select * from faridkot_ps");
        
       ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            if(rs.getInt(1)==(c1.getFirNo()))
           {
               return true;
           }}}
        
     catch(Exception e)
     {
         System.out.println("Exception in check Fir"+e);
     }}
 else if(pos.equals("Fazilka Police Station")){
     try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("select * from fazilka_ps");
        
       ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            if(rs.getInt(1)==(c1.getFirNo()))
           {
               return true;
           }
           
        }
     }
         
     catch(Exception e)
     {
         System.out.println("Exception in check Fir"+e);
     }}
 else if(pos.equals("Ludhiana Police Station")){
     try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("select * from ludhiana_ps");
        
       ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            if(rs.getInt(1)==(c1.getFirNo()))
           {
               return true;
           }
           
        }
     }
         
     catch(Exception e)
     {
         System.out.println("Exception in check Fir"+e);
     }}
 else if(pos.equals("Jalandhar Police Station")){
     try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("select * from jalandhar_ps");
        
       ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            if(rs.getInt(1)==(c1.getFirNo()))
           {
               return true;
           }
           
        }
     }
    catch(Exception e)
     {
         System.out.println("Exception in check Fir"+e);
     }}
 else if(pos.equals("Sangrur Police Station")){
     try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("select * from sangrur_ps");
        
       ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            if(rs.getInt(1)==(c1.getFirNo()))
           {
               return true;
           }
           
        }
     }
         
     catch(Exception e)
     {
         System.out.println("Exception in check Fir"+e);
     }}
     return false;
    }
     public boolean insertThought(thought t)
    {
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("insert into thoughts(Date,Thought)values(?,?)");
        ps.setString(1,t.getDate());
        ps.setString(2,t.getThought());
       
        int i=ps.executeUpdate();
        if(i>0)
            return true;
        }
        catch(Exception e){
            System.out.println("Exception in insertThought"+e);
        }
        return false;
    }
               public boolean adcheckLogin(Registeration ub)
    {
        
         try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("select * from login");
        
       ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
           String un=rs.getString(1).trim();
            String pas=rs.getString(2).trim();
           if( un.equals(ub.getUsername())&&pas.equals(ub.getPassword()))
           {
               return true;
           }
           
       }}
        catch(Exception e){
            System.out.println("Exception in login "+e);
        }
        return false;
    }
               public boolean insertnew(whatsnew w)
    {
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps=con.prepareStatement
                ("insert into whatsnew(Latest_news,Description)values(?,?)");
        ps.setString(1, w.getLatest_news());
            ps.setString(2, w.getDescription());
       int i=ps.executeUpdate();
        if(i>0)
            return true;
        }
        catch(Exception e){
            System.out.println("Exception in insertwanted "+e);
        }
        return false;
    }
    public boolean retrivethought(thought t1){
 
 try{
                      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("select * from thoughts");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
               String thought = rs.getString(3);
                
                t1.setThought(thought);
          }
        }
    catch(Exception e){
         System.out.println(" "+e);}
return false;
}
       public boolean retrivenew(whatsnew t1){
 
 try{
                      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("select * from whatsnew");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
               String ls= rs.getString(2);
                
                t1.setLatest_news(ls);
          }
        }
    catch(Exception e){
         System.out.println(" "+e);}
return false;
}
       public ArrayList retriveCategory(){
    ArrayList al=new ArrayList();
    try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
             PreparedStatement ps = con.prepareStatement("select * from category");

             ResultSet rs = ps.executeQuery();

             while (rs.next()) {
                 Category c1 = new Category();
                 String ct = rs.getString(2);
                 c1.setCategory(ct);
                 al.add(ct);
             }
         }
           catch(Exception e)
           {
               System.out.println("Exception in retrievecategory"+e);
           }
     return al;
       }
        public boolean insertCategory(Category c)
    {
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           Connection con= DriverManager.getConnection
                   ("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement
                ("insert into category(Category,Description)values(?,?)");
            ps.setString(1, c.getCategory());
            ps.setString(2, c.getDescription());
    
        int i=ps.executeUpdate();
        if(i>0)
            return true;
        }
        catch(Exception e){
            System.out.println("Exception in insertCategory "+e);
        }
        return false;
    }
        
        public boolean showStatus(CheckFir f1,String pos){
            System.out.println("welcome to....."+pos);
 if(pos.equals("Amritsar Police Station")){
 try{
     System.out.println("heloooooo");
                      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("select * from amritsar_ps");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
               String status= rs.getString(15);
                System.out.println(status);
                f1.setStatus(status);
          }
        }
    catch(Exception e){
         System.out.println(" "+e);}}
 else  if(pos.equals("Barnala Police Station")){
 try{
                      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("select * from barnala_ps");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
               String status= rs.getString(15);
               
                f1.setStatus(status);
          }
        }
    catch(Exception e){
         System.out.println(" "+e);}}
 else  if(pos.equals("Bathinda Police Station")){
 try{
                      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("select * from bathinda_ps");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
               String status= rs.getString(15);
               
                f1.setStatus(status);
          }
        }
    catch(Exception e){
         System.out.println(" "+e);}}
 else  if(pos.equals("Fazilka Police Station")){
 try{
                      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("select * from fazilka_ps");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
               String status= rs.getString(15);
               
                f1.setStatus(status);
          }
        }
    catch(Exception e){
         System.out.println(" "+e);}}
 else  if(pos.equals("Faridkot Police Station")){
 try{
                      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("select * from faridkot_ps");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
               String status= rs.getString(15);
               
                f1.setStatus(status);
          }
        }
    catch(Exception e){
         System.out.println(" "+e);}}
 else  if(pos.equals("Jalandhar Police Station")){
 try{
                      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("select * from jalandhar_ps");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
               String status= rs.getString(15);
               
                f1.setStatus(status);
          }
        }
    catch(Exception e){
         System.out.println(" "+e);}}
 else  if(pos.equals("Ludhiana Police Station")){
 try{
                      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("select * from ludhiana_ps");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
               String status= rs.getString(15);
               
                f1.setStatus(status);
          }
        }
    catch(Exception e){
         System.out.println(" "+e);}}
 else  if(pos.equals("Sangrur Police Station")){
 try{
                      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("select * from sangrur_ps");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
               String status= rs.getString(15);
             
                f1.setStatus(status);
          }
        }
    catch(Exception e){
         System.out.println(" "+e);}}
     
return  false;
}
           public String getuname(String un){
 String uname=null;
 try{
                      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("select * from registeration where Username=?");
ps.setString(1, un);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
              uname = rs.getString(2);
                
          
          }
        }
    catch(Exception e){
         System.out.println(" "+e);}
return uname;
}
public String getuname1(String un){
 String uname=null;
 try{
                      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
            PreparedStatement ps = con.prepareStatement("select * from login where Username=?");
ps.setString(1, un);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
              uname = rs.getString(2);
         }
        }
    catch(Exception e){
         System.out.println(" "+e);}
return uname;
}
public int getid(){
   
    int idmax;
    int id = 0;
    try{
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con=DriverManager.getConnection("jdbc:sqlserver://;databaseName=fir;userName=sa;password=root");
        PreparedStatement ps=con.prepareStatement("select * from Missing");
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
       idmax=rs.getInt(1);
       id=idmax+1; 
        }}
        catch(Exception e)
        {
            System.out.println("Exception ........"+e);
        }
         return id;
    }
}

        
