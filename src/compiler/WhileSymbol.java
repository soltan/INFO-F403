package compiler;

import parser.ParseTree;

import java.util.ArrayList;

public class WhileSymbol extends Symbol {

    private ConditionSymbol symbol;
    private ArrayList<InstructionSymbol> body;

    @Override
    public void set(ParseTree tree, CompilerTable table) {

    }

    @Override
    public String toLLVM() {
    }
}