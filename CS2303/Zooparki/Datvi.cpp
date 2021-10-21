#ifndef DATVI_CPP
#define DATVI_CPP


#include "Datvi.h"

Datvi::Datvi(){
	
}

Datvi::Datvi(int asaki, double wona, string sacxovrebeli, double simagle) : Cxoveli(asaki,wona,sacxovrebeli){
	this -> simagle = simagle;
}

double Datvi::getSimagle(){
	return simagle;
}

void Datvi::setSimagle(double simagle){
	this -> simagle = simagle;
}

//imistvis rom klasi ar iyos abstractuli aucilebelia gadavsazgvrot mshoblis funqcia arseboba()
void Datvi::arseboba(){
	cout<<"datvi cocxlobs"<<endl;
}

// >> gadatvirtva
istream & operator>> (istream & is , Datvi & d){
	d.wakitxva(is);
	double s;
	is>>s;
	d.setSimagle(s);
	return is;
}

ostream & operator<< (ostream & os, Datvi & d){
	os<<"informacia datvis shesaxeb : "<<endl;
	os<<"Datvi simagle aris "<<d.getSimagle()<<", ";
	d.bechdva(os);
	return os; 
}

#endif
