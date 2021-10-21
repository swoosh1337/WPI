#ifndef LOMI_H
#define LOMI_H

#include "Cxoveli.cpp"

class Lomi : public Cxoveli{
	protected:
		string saxeoba;
	
	public:
		//konstruqtorebi
		Lomi();
		Lomi(int, double, string, string);
		
		//get da set funqciebi
		string getSaxeoba();
		void setSaxeoba(string );
		
		//funqcia arseboba agar iqneba sufta virtualuri radgan klasi ar unda iyos abstraqtuli
		void arseboba();
		
		//wakitxvis operatoris gadatvirtva
		friend istream& operator>> ( istream & , Lomi &);
		
		friend ostream& operator<< ( ostream & , Lomi &);
};

#endif
