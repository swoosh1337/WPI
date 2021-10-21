#ifndef DATVI_H
#define DATVI_H


#include "Cxoveli.cpp"

class Datvi : public Cxoveli{
	protected:
		double simagle;
	
	public:
		//konstruqtorebi
		Datvi();
		Datvi(int, double, string, double);
		
		//get da set funqciebi
		double getSimagle();
		void setSimagle(double );
		
		//funqcia arseboba agar iqneba sufta virtualuri radgan klasi ar unda iyos abstraqtuli
		void arseboba();
		
		//wakitxvis operatoris gadatvirtva
		friend istream& operator>> ( istream & , Datvi &);
		
		friend ostream& operator<< (ostream & , Datvi & );
};

#endif
