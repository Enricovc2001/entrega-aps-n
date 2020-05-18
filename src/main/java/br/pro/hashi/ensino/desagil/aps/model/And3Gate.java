package br.pro.hashi.ensino.desagil.aps.model;

public class And3Gate extends Gate {
    private final NandGate nand1;
    private final NandGate nand2;
    private final NandGate nand3;
    private final NandGate nand4;

    public And3Gate() {
        super("AND3", 3);
        // nand 1
        nand1 = new NandGate();

        // nand 2
        nand2 = new NandGate();
        nand2.connect(0, nand1);
        nand2.connect(1, nand1);
        // nand 3
        nand3 = new NandGate();
        nand3.connect(0, nand2);

        //nand 4
        nand4 = new NandGate();
        nand4.connect(0, nand3);
        nand4.connect(1, nand3);



    }

    @Override
    public boolean read() {
        return nand4.read();
    }

    @Override
    public void connect(int inputIndex, Emitter emitter) {
        switch (inputIndex) {
            case 0:
                nand1.connect(0,emitter);
            case 1:
                nand1.connect(1,emitter);
                case 2:
                nand3.connect(1, emitter);
                break;

        }
    }

}

