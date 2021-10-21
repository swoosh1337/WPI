#include "Datvi.cpp"
#include "Lomi.cpp"
#include "Arwivi.cpp"
#include "Bu.cpp"
#include <windows.h>    //feristvis
#include <conio.h>		//parolistvis

void shesveneba(){
	for (int i=0; i<200000000; i++){
		int x=0;
		x++;
		x--;
	}
}

void admini(){
	system("CLS");
	cout<<"sheiyvanet 6 simboloiani paroli"<<endl;
	char c;
	string paroli;
	for (int i=0; i<6; i++){
		
		
		c = _getch();
		cout<<"*";
		paroli = paroli + c;
	}
	if (paroli != "paroli"){
		cout<<endl<<"scadet tavidan"<<endl;
		shesveneba();
		admini();
	}else{
		system("CLS");
		cout<<"paroli sworia."<<endl;
		cout<<endl<<"romeli arsebis damateba ginda?"<<endl;
		cout<<"1. Lomi"<<endl;
		cout<<"2. Datvi"<<endl;
		cout<<"3. Arwivi"<<endl;
		cout<<"4. Bu"<<endl;
		int x;
		cin>>x;
		if (x==1){
			ofstream ofs("file//lomi.txt",ios_base::app); // faili romelshic yovel jerze miemateba da tavidan ar daiwyeba
			cout<<"sheitane asaki,wona,sacxovrebeli da saxeoba."<<endl;
			Lomi l;
			cin>>l;
			ofs<<l.getAsaki()<<" "<<l.getWona()<<" "<<l.getAdgili()<<" "<<l.getSaxeoba()<<endl;
		}
		if (x==2){
			ofstream ofs("file//Datvi.txt",ios_base::app); // faili romelshic yovel jerze miemateba da tavidan ar daiwyeba
			cout<<"sheitane asaki,wona,sacxovrebeli da simagle."<<endl;
			Datvi l;
			cin>>l;
			ofs<<l.getAsaki()<<" "<<l.getWona()<<" "<<l.getAdgili()<<" "<<l.getSimagle()<<endl;
		}
		if (x==3){
			ofstream ofs("file//Arwivi.txt",ios_base::app); // faili romelshic yovel jerze miemateba da tavidan ar daiwyeba
			cout<<"sheitane asaki,wona,sichqare da saxeli."<<endl;
			Arwivi l;
			l.arwivisWakitxva(cin); //arwivistvis gvaqvs funqcia, wakitxva ar gadagvitvirtia
			ofs<<l.getAsaki()<<" "<<l.getWona()<<" "<<l.getSichqare()<<" "<<l.getSaxeli()<<endl;
		}
		if (x==4){
			ofstream ofs("file//Bu.txt",ios_base::app); // faili romelshic yovel jerze miemateba da tavidan ar daiwyeba
			cout<<"sheitane asaki,wona,sichqare da dzilis dro."<<endl;
			Bu l;
			l.busWakitxva(cin);
			ofs<<l.getAsaki()<<" "<<l.getWona()<<" "<<l.getSichqare()<<" "<<l.getDzili()<<endl;
		}
		cout<<"gaixare dzma axali cxoveli dagitrevia.  :D"<<endl;
	}
}


void momxmarebeli(){
	system("CLS");
	cout<<"paroli sworia."<<endl;
	cout<<endl<<"romel arsebaze ginda informacia?"<<endl;
	cout<<"1. Lomi"<<endl;
	cout<<"2. Datvi"<<endl;
	cout<<"3. Arwivi"<<endl;
	cout<<"4. Bu"<<endl;
	int x;
	cin>>x;
	if (x==1){
			ifstream ifs("file//lomi.txt");
			Lomi l;
			while (ifs>>l){
				cout<<l;
			}
		}
		if (x==2){
			ifstream ifs("file//Datvi.txt");
			Datvi l;
			while (ifs>>l){
				cout<<l;
			}
		}
		if (x==3){
			//radganac << da >> ar gadagvitvirtia cota bodaili dachirda :D
			ifstream ifs("file//Arwivi.txt");
			Arwivi l,l1;
			while (true){
				l.arwivisWakitxva(ifs);
				if (l.getSaxeli()==l1.getSaxeli())
				break;
				l1=l;
				l.arwivisBechdva(cout);
			}                               
		}
		if (x==4){
			ifstream ifs("file//Bu.txt");
			Bu l,l1;
			while (true){
				l.busWakitxva(ifs);
				if (l.getAsaki()==l1.getAsaki() && l.getWona()==l1.getWona())
				break;
				l1=l;
				l.busBechdva(cout);
			} 
		}
	
}


int main(){
	system ("COLOR F2");
	
	cout<<"kai gamarjoba, mobrdzandit :)"<<endl;
	cout<<"momxmarebeli xart tu administratori?"<<endl;
	cout<<"1. momxmarebeli"<<endl;
	cout<<"2. administratori"<<endl;
	
	int shesvla;
	cin>>shesvla;
	if (shesvla == 1){
		momxmarebeli();
	}else{
		admini();
	}
	
	
	return 0;
}
