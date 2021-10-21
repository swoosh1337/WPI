#ifndef ARWIVI_H
#define ARWIVI_H

#include "Frinveli.cpp"

class Arwivi : public Frinveli{
	protected:
		string saxeli;
		
	public:
		Arwivi();
		Arwivi(int, double, double, string);
		
		string getSaxeli();
		void setSaxeli(string );
		
		void arseboba();
		
		//wakitxvistvis gavaketot funqcia. shegvedzlo gadagvetvirtva rogorc lomis da datvis klasshia tumca vnaxot aseti variantic
		void arwivisWakitxva(istream & is);
		
		//igive gaaketot bechdvistvisac
		void arwivisBechdva(ostream & os);
};

#endif
