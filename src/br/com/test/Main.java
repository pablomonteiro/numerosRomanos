package br.com.test;

public class Main {
	
	public static void main(String[] args) {
		
		Main main = new Main();
		System.out.println(main.converteParaNumeroRomano(91));

	}
	
	public String converteParaNumeroRomano(Integer valor){
		RangeRomanos range = new RangeRomanos(valor);
		String rangeString = "";
		
		if(range.ehRangeIgual()){
			rangeString += range.fim.getDescricao();
			
		} else if(range.rangeIgualAValor(valor)){
			rangeString += range.inicio.getDescricao() + range.fim.getDescricao();
			
		} else {
			rangeString += range.inicio.getDescricao();
			Integer resto = valor - (range.inicio.getValor());
			rangeString += converteParaNumeroRomano(resto);
		}
		
		return rangeString;
	}
	
	public class RangeRomanos {
		
		private Romano inicio;
		private Romano fim;
		
		public RangeRomanos(Integer valor){
			geraRangeRomano(valor);
		}
		
		public RangeRomanos(Romano inicio, Romano fim){
			this.inicio = inicio;
			this.fim = fim;
		}
		
		public Romano getInicio() {
			return inicio;
		}
		public void setInicio(Romano inicio) {
			this.inicio = inicio;
		}
		public Romano getFim() {
			return fim;
		}
		public void setFim(Romano fim) {
			this.fim = fim;
		}
		
		private void geraRangeRomano(Integer valor){
			this.inicio = Romano.verificaValorMinimo(valor);
			this.fim = Romano.verificaValorMaximo(valor);
		}
		
		public Boolean rangeIgualAValor(Integer valor){
			return fim.getValor() - inicio.getValor() == valor;
		}
		
		public Boolean fimMenosInicioForMenorAoValor(Integer valor){
			return fim.getValor() - inicio.getValor() < valor;
		}
		
		public Boolean ehRangeIgual(){
			return fim.getValor() == inicio.getValor();
		}
	}
	
	public enum Romano{
		
		I {
			public Integer getValor(){ return 1; }
			public String getDescricao(){ return "I";}
			public boolean ehMaiorIgualA(Integer valor){
				return (getValor() >= valor) ? true : false; 
			}
		},
		V {
			public Integer getValor(){ return 5; }
			public String getDescricao(){ return "V";}
			public boolean ehMaiorIgualA(Integer valor){
				return (getValor() >= valor) ? true : false; 
			}
		},
		IX {
			public Integer getValor(){ return 9; }
			public String getDescricao(){ return "IX";}
			public boolean ehMaiorIgualA(Integer valor){
				return (getValor() >= valor) ? true : false; 
			}
		},
		X {
			public Integer getValor(){ return 10; }
			public String getDescricao(){ return "X";}
			public boolean ehMaiorIgualA(Integer valor){
				return (getValor() >= valor) ? true : false; 
			}
		},
		XL {
			public Integer getValor(){ return 40; }
			public String getDescricao(){ return "XL";}
			public boolean ehMaiorIgualA(Integer valor){
				return (getValor() >= valor) ? true : false; 
			}
		},
		L {
			public Integer getValor(){ return 50; }
			public String getDescricao(){ return "L";}
			public boolean ehMaiorIgualA(Integer valor){
				return (getValor() >= valor) ? true : false; 
			}
		},
		XC {
			public Integer getValor(){ return 90; }
			public String getDescricao(){ return "XC";}
			public boolean ehMaiorIgualA(Integer valor){
				return (getValor() >= valor) ? true : false; 
			}
		},
		C {
			public Integer getValor(){ return 100; }
			public String getDescricao(){ return "C";}
			public boolean ehMaiorIgualA(Integer valor){
				return (getValor() >= valor) ? true : false; 
			}
		},
		CD{
			public Integer getValor(){ return 400; }
			public String getDescricao(){ return "CD";}
			public boolean ehMaiorIgualA(Integer valor){
				return (getValor() >= valor) ? true : false; 
			}
		},
		D{
			public Integer getValor(){ return 500; }
			public String getDescricao(){ return "D";}
			public boolean ehMaiorIgualA(Integer valor){
				return (getValor() >= valor) ? true : false; 
			}
		},
		CM {
			public Integer getValor(){ return 900; }
			public String getDescricao(){ return "CM";}
			public boolean ehMaiorIgualA(Integer valor){
				return (getValor() >= valor) ? true : false; 
			}
		},
		M {
			public Integer getValor(){ return 1000; }
			public String getDescricao(){ return "M";}
			public boolean ehMaiorIgualA(Integer valor){
				return (getValor() >= valor) ? true : false; 
			}
		};
		
		public abstract Integer getValor();
		
		public abstract String getDescricao();
		
		public abstract boolean ehMaiorIgualA(Integer valor);
		
		private static Romano verificaValorMinimo(Integer valor) {
			if(V.ehMaiorIgualA(valor))
				return (V.getValor() == valor) ? V : I;
			if(IX.ehMaiorIgualA(valor))
				return (IX.getValor() == valor) ? IX : V;
			if(X.ehMaiorIgualA(valor))
				return (X.getValor() == valor) ? X : IX;
			if(XL.ehMaiorIgualA(valor))
				return (XL.getValor() == valor) ? XL : X;
			if(L.ehMaiorIgualA(valor))
				return (L.getValor() == valor) ? L : XL;
			if(XC.ehMaiorIgualA(valor))
				return (XC.getValor() == valor) ? XC : L;
			if(C.ehMaiorIgualA(valor))
				return (C.getValor() == valor) ? C : XC;
			if(CD.ehMaiorIgualA(valor))
				return (CD.getValor() == valor) ? CD : C;
			if(D.ehMaiorIgualA(valor))
				return (D.getValor() == valor) ? D : CD;
			if(CM.ehMaiorIgualA(valor))
				return (CM.getValor() == valor) ? CM : D;
			if(M.ehMaiorIgualA(valor))
				return (M.getValor() == valor) ? M : CM;
			return M;
		}
		
		private static Romano verificaValorMaximo(Integer valor) {
			if(I.ehMaiorIgualA(valor))
				return I;
			if(V.ehMaiorIgualA(valor))
				return V;
			if(IX.ehMaiorIgualA(valor))
				return IX;
			if(X.ehMaiorIgualA(valor))
				return X;
			if(XL.ehMaiorIgualA(valor))
				return XL;
			if(L.ehMaiorIgualA(valor))
				return L;
			if(XC.ehMaiorIgualA(valor))
				return XC;
			if(C.ehMaiorIgualA(valor))
				return C;
			if(CD.ehMaiorIgualA(valor))
				return CD;
			if(D.ehMaiorIgualA(valor))
				return D;
			if(CM.ehMaiorIgualA(valor))
				return CM;
			return M;
		}
		
	}
	
}
