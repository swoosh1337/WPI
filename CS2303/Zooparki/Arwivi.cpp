#ifndef ARWIVI_CPP
#define ARWIVI_CPP

#include "Arwivi.h"

Arwivi::Arwivi(){
	
}

Arwivi::Arwivi(int asaki, double wona, double frenisSichqare, string saxeli) : Frinveli(asaki,wona,frenisSichqare){
	this -> saxeli = saxeli;
}

string Arwivi::getSaxeli(){
	return saxeli;
}

void Arwivi::setSaxeli(string saxeli){
	this -> saxeli = saxeli;
}

void Arwivi::arseboba(){
	cout<<"arwivi cocxlobs"<<endl;
}

ifstream & operator>> (ifstream &ifs , Arwivi a){
	a.wakitxva(ifs);
	string x;
	ifs>>x;
	a.setSaxeli(x);
	return ifs;
}

//wakitxvis funqcia
void Arwivi::arwivisWakitxva(istream & is){
	wakitxva(is);
	is>>saxeli;
}

void Arwivi::arwivisBechdva(ostream & os){
	cout<<"informacia arwivis shesaxeb : "<<endl;
	cout<<"arwivis saxeli aris "<<saxeli<<", ";
	bechdva(os);
}


#endif
