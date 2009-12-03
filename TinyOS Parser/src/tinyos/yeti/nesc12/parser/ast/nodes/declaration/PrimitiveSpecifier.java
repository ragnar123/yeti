/*
 * Yeti 2, NesC development in Eclipse.
 * Copyright (C) 2009 ETH Zurich
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Web:  http://tos-ide.ethz.ch
 * Mail: tos-ide@tik.ee.ethz.ch
 */
package tinyos.yeti.nesc12.parser.ast.nodes.declaration;

import tinyos.yeti.nesc12.lexer.Token;
import tinyos.yeti.nesc12.parser.ast.ASTVisitor;
import tinyos.yeti.nesc12.parser.ast.AnalyzeStack;
import tinyos.yeti.nesc12.parser.ast.nodes.AbstractTokenASTNode;

public class PrimitiveSpecifier extends AbstractTokenASTNode implements TypeSpecifier{
    public static enum Type{
        CHAR,
        SHORT,
        INT,
        LONG,
        FLOAT,
        DOUBLE,
        SIGNED,
        UNSIGNED,
        VOID,
        _BOOL,
        _COMPLEX
    }
    
    private Type type;
    
    public PrimitiveSpecifier( Token token, Type type ){
        super( "PrimitiveSpecifier", token );
        this.type = type;
    }
    
    public boolean isStorageClass() {
        return false;
    }
    
    public boolean isSpecifier() {
        return true;
    }
    
    public boolean isPrimitive() {
        return true;
    }
    
    public boolean isDataObject() {
        return false;
    }
    
    public boolean isEnum() {
        return false;
    }
    
    public boolean isTypedefName() {
        return false;
    }
    
    public boolean isAttribute(){
        return false;
    }
    
    public void setType( Type type ) {
        this.type = type;
    }
    public Type getType() {
        return type;
    }
    
    @Override
    protected boolean visit( ASTVisitor visitor ) {
        return visitor.visit( this );
    }

    @Override
    protected void endVisit( ASTVisitor visitor ) {
        visitor.endVisit( this );
    }

    @Override
    public void resolve( AnalyzeStack stack ) {
        // TODO method not implemented
        super.resolve( stack );
    }
}
