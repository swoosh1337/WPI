#include <iostream>
#include <string>
#include <fstream>
using namespace std;    
 
class Adamiani{
      protected:
      string saxeli;
      string gvari;
      string erovneba;
      int xelfasi;
      int asaki;
      public:
      virtual void suntqva()=0;
      Adamiani();
      Adamiani(string,string,string,int,int);
      string getSaxeli();
      string getGvari();
      string getErovneba();
      int    getAsaki();
      int    getXelfasi();
      void   setSaxeli   (string );
      void   setGvari    (string );
      void   setErovneba (string );
      void   setAsaki    (int    );  
      void   setXelfasi  (int    );       

    void wakitxva(istream &); 
	void bechdva(ostream &);  
	
      };
      
      
      
      class Fexburteli:public Adamiani{
            private:
                    string pozitsia;
                    int golebisraodenoba;
                    int  assistebisraodenoba;
                    int   mchmraodenoba;
                    public:
              Fexburteli();
			  Fexburteli(int,int,int) ;
			  int getGolebisraodenoba();
			  int getAssistebisraodenoba();
			  int getMchmraodenoba();
			  void setGolebisraodenoba(int );
			  void setAssistebisraodenoba(int );
			  void setMchmraodenoba(int ) ;    
          
		    
		    void suntqva();
            
             };
            
            
        
            
           
      class Mwvrtneli:public Adamiani{
            private:
            string titulebi;        
            string tanamdeboba;
            int gamocdileba;
            public:
            	Mwvrtneli();
            	Mwvrtneli(string ,string , int );
				string  getTitulebi();
				string  getTanamdeboba();
				int     getGamocdileba();
                void    setTitulebi(string    );
                void    setTanamdeboba(string );
                void    setGamocdileba(int    ); 	
            
            void suntqva();
            
            
            
            
            };
                  class Shenoba{
                        protected:
                        void virtual Garemonteba()=0;
                       string  adgilmdebareoba;
                       string  direqtori;
                       int     asaki; 
					   int     gadasaxadebi;  
                        public:
                        Shenoba();
                        Shenoba(string ,string ,int , int );
                        string getAdgilmdebareoba();
                        string getDireqtori();
                        int    getAsaki();
                        int    getGadasaxadebi();
                        void   setAdgilmdebareoba(string );
                        void   setDireqtori(string );
                        void   setAsaki(int );
                        void   setGadasaxadebi(int );
                         };
                        
            class Stadioni:public Shenoba{
                  private:            
                       int tevadoba;
                       string mdebareoba;
                  public:  
                     Stadioni();
                     Stadioni(int,string);
                     int getTevadoba();
                     string getMdebareoba();
                     void setTevadoba();
                     void setMdebareoba();   
                     };
      
      Adamiani::Adamiani(){}
      Adamiani::Adamiani(string saxeli,string gvari,string erovneba,int xelfasi,int asaki){
             this->saxeli=saxeli;
             this->gvari=gvari;
             this->erovneba=erovneba;
             this->asaki=asaki;
                    }
             string Adamiani::getSaxeli(){
                    return saxeli;
                    }
             string Adamiani::getGvari(){
                    return gvari;
                    }                           
             string Adamiani::getErovneba(){
                    return erovneba;
                    }      
             int    Adamiani::getAsaki(){
                    return asaki;
                    }     
			int     Adamiani::getXelfasi(){
				return xelfasi;
			        }		 
             void   Adamiani::setSaxeli(string saxeli){
                    this->saxeli=saxeli;
                    }
             void   Adamiani::setGvari(string gvari){
                    this->gvari=gvari;
                    }
             void   Adamiani::setErovneba(string erovneba){
                    this->erovneba=erovneba;
                    }
             void   Adamiani::setAsaki(int asaki){
                    this->asaki=asaki;
                    }              
             void   Adamiani::setXelfasi(int xelfasi){
             	    this->xelfasi=xelfasi;
			        }                        
			     void Adamiani::wakitxva(istream &is){
                     is>>saxeli>>gvari>>erovneba>>xelfasi>>asaki;
                     }
                 void Adamiani::bechdva(ostream &os){
                     os<<"misi saxeli aris- "  <<saxeli<< "  gvari- "<<gvari<< " erovneba- " <<erovneba<< " xelfasi- " <<xelfasi<< " asaki "<<asaki<<"weli"<<endl;    
                     }
			        
			        
		/*Stadioni::Stadioni(){}
        Stadioni::Stadioni(int tevadoba,string mdebareoba):Shenoba( asaki,gadasaxadebi){
                               this->tevadoba=tevadoba;
                               this->mdebareoba=mdebareoba;
                               }	        
              int Stadioni::getTevadoba()){
              	return tevadoba;
			  }             
          string Stadioni::getMdebareoba(){
          	return mdebareoba;
		  } 
           void Stadioni::setTevadoba(int tevadoba){
           	this->tevadoba=tevadoba;
		   }
     void    Stadioni::setMdebareoba(string mdebareoba){
     	this->mdebareoba=mdebareoba;
	 }*/
			        
			        
			 Fexburteli::Fexburteli(){};
			 Fexburteli::Fexburteli(int golebisraodenoba,int assistebisraodenoba,int mchmraodenoba):Adamiani( saxeli, gvari, erovneba, xelfasi, asaki){
			 this->golebisraodenoba=golebisraodenoba;
			 this->assistebisraodenoba=assistebisraodenoba;
			 this->mchmraodenoba=mchmraodenoba;	
            	   }  
			 
			 int Fexburteli::getGolebisraodenoba(){
			 	return golebisraodenoba;
			      }     
			 int Fexburteli::getAssistebisraodenoba(){
			 	return assistebisraodenoba;
			      }
			        
			 int Fexburteli::getMchmraodenoba(){
			 	return mchmraodenoba;
			     }     
			 void Fexburteli::setGolebisraodenoba(int golebisraodenoba){
			      this->golebisraodenoba=golebisraodenoba;
			     }       
			 void Fexburteli::setAssistebisraodenoba(int assistebisraodenoba){
		          this->assistebisraodenoba=assistebisraodenoba;	 
			     }       
			 void Fexburteli::setMchmraodenoba(int mchmraodenoba){
			 	  this->mchmraodenoba=mchmraodenoba;
			    }       
			    

           
                          
              void Fexburteli::suntqva(){
                   cout<<"suntqavs"<<endl;
                   }
			    istream & operator>> (istream &ifs , Fexburteli &a){
              	a.wakitxva(ifs);
	            int golebisraodenoba;
	            int assistebisraodenoba;
	            int  mchmraodenoba;
                ifs>>golebisraodenoba>>assistebisraodenoba>>mchmraodenoba;
	            a.setGolebisraodenoba(golebisraodenoba);
	            a.setAssistebisraodenoba(assistebisraodenoba);
	            a.setMchmraodenoba(mchmraodenoba);
	            return ifs;
             }
               ostream & operator<< (ostream &ofs , Fexburteli &a){
                    ofs<<"iformacia fexburtelis shesaxeb"<<endl;
                       a.bechdva(ofs);
                
                   ofs<<"golebis raodenoba-"<< a.getGolebisraodenoba() << " assistebisraodenoba-" <<a.getAssistebisraodenoba()<< "   mchmraodenoba-  " <<a.getMchmraodenoba()<<endl;
                   }
			    
			    
			 Mwvrtneli::Mwvrtneli(){};
			 Mwvrtneli::Mwvrtneli(string titulebi,string tanamdeboa,int gamocdileba):Adamiani(saxeli,gvari,erovneba,xelfasi,asaki){
			 	
			 	  this->titulebi=titulebi;
			 	  this->tanamdeboba=tanamdeboba;
			 	  this->gamocdileba=gamocdileba;
		       }
		string 	 Mwvrtneli::getTitulebi(){
			 	return titulebi;
			 }
 		string	  Mwvrtneli::getTanamdeboba(){
			  	return tanamdeboba;
	       	 }
		int	  Mwvrtneli::getGamocdileba(){
                return gamocdileba;  			  
			  	
		     }
		 void Mwvrtneli::setTitulebi(string titulebi){
		       	this->titulebi=titulebi;
	        }
		void  Mwvrtneli::setTanamdeboba(string tanamdeboba){
			    this->tanamdeboba=tanamdeboba;
	       } 
		void  Mwvrtneli::setGamocdileba(int gamocdileba){
			 	this->gamocdileba=gamocdileba;
	       }                            
	       
	       void Mwvrtneli::suntqva(){
                cout<<"suntqavs"<<endl;
                }
	       
	        istream & operator>> (istream &ifs , Mwvrtneli& a){
              	a.wakitxva(ifs);
	            string  titulebi;
                string  tanamdeboba;
                int gamocdileba;	           
                ifs>>titulebi>>tanamdeboba>>gamocdileba;
	            a.setTitulebi(titulebi);
	            a.setTanamdeboba(tanamdeboba);
	            a.setGamocdileba(gamocdileba);
	            return ifs;
             }
	       ostream & operator<< (ostream &ofs , Mwvrtneli &a){
                    ofs<<"informacia mwvrtnelis shesaxeb"<<endl;
                       a.bechdva(ofs);
                   ofs<<"titulebi-"<< a.getTitulebi() << " tanamdeboba-" <<a.getTanamdeboba()<< "   gamocdileba-  " <<a.getGamocdileba()<<"weli"<<endl;
                return ofs;   
               }
                   
			    
	       
	       
			 Shenoba::Shenoba(){};
			 Shenoba::Shenoba(string adgilmdebareoba,string direqtori,int asaki,int gadasaxedebi){
			 	this->adgilmdebareoba=adgilmdebareoba;
			 	this->direqtori=direqtori;
			 	this->asaki=asaki;
			 	this->gadasaxadebi=gadasaxadebi;
			 	
			 } 
     string 		     Shenoba::getAdgilmdebareoba(){
		     	return adgilmdebareoba;
			 }                  
	string	    Shenoba::getDireqtori(){
		    	return direqtori;
			}  
	int		Shenoba::getAsaki(){
				return asaki;
			}  			  
 	int		 Shenoba::getGadasaxadebi(){
			 	return gadasaxadebi;
			 }  	
		void  Shenoba::setAdgilmdebareoba(string){
			this->adgilmdebareoba=adgilmdebareoba;
		}
		void Shenoba::setDireqtori(string){
			this->direqtori=direqtori;
		} 
		void Shenoba::setAsaki(int asaki){
			this->asaki=asaki;
		}
		void Shenoba::setGadasaxadebi(int gadasaxadebi){
			this->gadasaxadebi=gadasaxadebi;
		} 	 
		
		
void mtavari(){
     cout<<"vis an ris shesaxeb ginda informacia?"<<endl;
    cout<<" 1.fexburteli \n 2.mwvrtneli \n 3.stadioni"<<endl;
    int n,k,m,t;
    cin>>k;
    system("cls");
    if(k==1){
             cout<<"romel fexburtelze ginda informacia"<<endl;
    string a[11]={"ronaldo","gareth bale","karim benzema","luca modric","isco","toni kroos","marcelo","sergio ramos","pepe","dani carvajal","iker casillas"};
  
for(int i=0;i<11;i++){
        cout<<i+1<<'.'<<a[i]<<endl;
        }
  cin>>n;
  system("cls");
  string failisSaxeli = a[n-1] + ".txt";
  ifstream ifs(failisSaxeli.c_str());
    Fexburteli f;
    ifs>>f;
    cout<<f<<endl;
}
if(k==2){
         cout<<"romel mwvrtnelze ginda iformacia"<<endl;
         string b[2]={"a","b"};
         for(int i=0;i<2;i++){
                 cout<<i+1<<'.'<<b[i]<<endl;
                 }
                 
                 cin>>t;
                 system("cls");
                 string failisSaxeli=b[t-1]+ ".txt";
                 
                 ifstream ifs(failisSaxeli.c_str());
                 
                 Mwvrtneli v;
                 
                 ifs>>v;
                 cout<<v.getTitulebi()<<endl;
                 cout<<v<<endl;
                 
                 
}


cout<<endl<<endl;
cout<<"kidev gaqvt kitxvebi?"<<endl;
cout<<" 1.ki \n 2.ara"<<endl;
cin>>m;
if(m==1){
         system("cls");
         mtavari();
         }
         
     }		
		

int main(){
    mtavari();
    
    
system("pause");
return 0;   
    
}
