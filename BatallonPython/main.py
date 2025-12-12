from enums import TipoBatallon, TipoEscuadra, TipoPeloton, RangoSoldado
from soldado import Soldado
from escuadra import Escuadra
from peloton import Peloton
from batallon import Batallon

def demo():
    print("=== DEMO Batallón ===")
    s1 = Soldado("Carlos Ruiz", 25, RangoSoldado.CABO, "APTO")
    s2 = Soldado("Miguel Torres", 30, RangoSoldado.SARGENTO, "APTO")
    s3 = Soldado("Juan Diaz", 19, RangoSoldado.RECLUTA, "HERIDO")

    esc = Escuadra("Alfa", 1, TipoEscuadra.INFANTERIA)
    esc.agregar_soldado(s1)
    esc.agregar_soldado(s2)
    esc.agregar_soldado(s3)

    pel = Peloton("Bravo", "Comandante X", TipoPeloton.ASALTO)
    pel.agregar_escuadra(esc)

    Batallon.cambiar_codigo_otan("CO-123")
    bat = Batallon("Batallon 1", "Bogotá", TipoBatallon.LIGERO)
    bat.agregar_peloton(pel)

    print(bat.generar_reporte_resumen())

if __name__ == "__main__":
    demo()
