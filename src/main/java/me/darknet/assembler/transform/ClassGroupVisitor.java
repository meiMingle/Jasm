package me.darknet.assembler.transform;

import me.darknet.assembler.exceptions.AssemblerException;
import me.darknet.assembler.parser.groups.annotation.AnnotationGroup;
import me.darknet.assembler.parser.groups.attributes.*;
import me.darknet.assembler.parser.groups.module.ModuleGroup;
import me.darknet.assembler.parser.groups.record.RecordGroup;

public interface ClassGroupVisitor extends GroupVisitor {
	/**
	 * Visit a generic field-level attribute
	 * @param group Generic field attribute group.
	 * @throws AssemblerException if an error occurrs
	 */
	default void visitAttribute(ClassAttributeGroup group) throws AssemblerException {
		if (group instanceof AnnotationGroup) {
			visitAnnotation((AnnotationGroup) group);
		} else if (group instanceof SignatureGroup) {
			visitSignature((SignatureGroup) group);
		} else if (group instanceof VersionGroup) {
			visitVersion((VersionGroup) group);
		} else if (group instanceof SourceFileGroup) {
			visitSourceFile((SourceFileGroup) group);
		} else if (group instanceof InnerClassGroup) {
			visitInnerClass((InnerClassGroup) group);
		} else if (group instanceof NestHostGroup) {
			visitNestHost((NestHostGroup) group);
		} else if (group instanceof NestMemberGroup) {
			visitNestMember((NestMemberGroup) group);
		} else if (group instanceof ModuleGroup) {
			visitModule((ModuleGroup) group);
		} else if (group instanceof PermittedSubclassGroup) {
			visitPermittedSubclass((PermittedSubclassGroup) group);
		} else if (group instanceof RecordGroup) {
			visitRecord((RecordGroup) group);
		} else if (group instanceof DeprecatedGroup) {
			visitDeprecated((DeprecatedGroup) group);
		}
	}

	/**
	 * Visit an annotation
	 * @param annotation the annotation group
	 * @throws AssemblerException if an error occurs
	 */
	void visitAnnotation(AnnotationGroup annotation) throws AssemblerException;

	/**
	 * Visit a signature
	 * @param signature the signature group
	 * @throws AssemblerException if an error occurs
	 */
	void visitSignature(SignatureGroup signature) throws AssemblerException;

	/**
	 * Visit a class version attribute
	 * @param version the version group
	 * @throws AssemblerException if an error occurs
	 */
	void visitVersion(VersionGroup version) throws AssemblerException;

	/**
	 * Visit a source file attribute
	 * @param sourceFile the source file group
	 * @throws AssemblerException if an error occurs
	 */
	void visitSourceFile(SourceFileGroup sourceFile) throws AssemblerException;

	/**
	 * Visit an inner class attribute
	 * @param innerClass the inner class group
	 * @throws AssemblerException if an error occurs
	 */
	void visitInnerClass(InnerClassGroup innerClass) throws AssemblerException;

	/**
	 * Visit a nest host attribute
	 * @param nestHost the nest host group
	 * @throws AssemblerException if an error occurs
	 */
	void visitNestHost(NestHostGroup nestHost) throws AssemblerException;

	/**
	 * Visit a nest member attribute
	 * @param nestMember the nest member group
	 * @throws AssemblerException if an error occurs
	 */
	void visitNestMember(NestMemberGroup nestMember) throws AssemblerException;

	/**
	 * Visit a module attribute
	 * @param module the module group
	 * @throws AssemblerException if an error occurs
	 */
	void visitModule(ModuleGroup module) throws AssemblerException;

	/**
	 * Visit a record attribute
	 * @param record the record group
	 * @throws AssemblerException if an error occurs
	 */
	void visitRecord(RecordGroup record) throws AssemblerException;

	/**
	 * Visit a permitted subclass attribute
	 * @param permittedSubclass the permitted subclass group
	 * @throws AssemblerException if an error occurs
	 */
	void visitPermittedSubclass(PermittedSubclassGroup permittedSubclass) throws AssemblerException;

	/**
	 * Visit a deprecated attribute
	 * @param deprecated the deprecated group
	 * @throws AssemblerException if an error occurs
	 */
	void visitDeprecated(DeprecatedGroup deprecated) throws AssemblerException;
}
