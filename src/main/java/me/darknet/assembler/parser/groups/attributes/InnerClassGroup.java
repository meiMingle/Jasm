package me.darknet.assembler.parser.groups.attributes;

import lombok.Getter;
import me.darknet.assembler.parser.Group;
import me.darknet.assembler.parser.Token;
import me.darknet.assembler.parser.groups.IdentifierGroup;

import java.util.Arrays;

@Getter
public class InnerClassGroup extends Group implements ClassAttributeGroup {

    private final AccessModsGroup accessMods;
    private final IdentifierGroup name;
    private final IdentifierGroup outerName;
    private final IdentifierGroup innerName;

    public InnerClassGroup(Token token, AccessModsGroup accessMods, IdentifierGroup name, IdentifierGroup outerName, IdentifierGroup innerName) {
        super(GroupType.INNER_CLASS_DIRECTIVE, token, Arrays.asList(accessMods, name, outerName, innerName));
        this.accessMods = accessMods;
        this.name = name;
        this.outerName = outerName;
        this.innerName = innerName;
    }
}
