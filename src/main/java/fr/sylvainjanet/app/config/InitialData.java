package fr.sylvainjanet.app.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import fr.sylvainjanet.app.entities.LocalizedString;
import fr.sylvainjanet.app.entities.TextLanguage;

/**
 * Initial data class.
 * 
 * @author Sylvain
 *
 */
public final class InitialData {

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_SYLVAIN_JANET =
      new EnumMap<TextLanguage, String>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_FRENCH_LANGUAGE_NAME =
      new EnumMap<TextLanguage, String>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_ENGLISH_LANGUAGE_NAME =
      new EnumMap<TextLanguage, String>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_MAIN_TITLE =
      new EnumMap<TextLanguage, String>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_OCCUPATION_TRAINER =
      new EnumMap<TextLanguage, String>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  // CSOFF: LineLength - this line can't be made shorter
  private static final Map<TextLanguage, String> TEXTMAP_OCCUPATION_MATHEMATICIAN =
      new EnumMap<TextLanguage, String>(TextLanguage.class);
  // CSON: LineLength
  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_OCCUPATION_MUSICIAN =
      new EnumMap<TextLanguage, String>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  // CSOFF: LineLength - this line can't be made shorter
  private static final Map<TextLanguage, String> TEXTMAP_OCCUPATION_FULLSTACK_DEV =
      new EnumMap<TextLanguage, String>(TextLanguage.class);
  // CSON: LineLength

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_SKILLS_TITLE =
      new EnumMap<TextLanguage, String>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_JAVA_LANGUAGE =
      new EnumMap<TextLanguage, String>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_CSHARP_LANGUAGE =
      new EnumMap<TextLanguage, String>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_PYTHON_LANGUAGE =
      new EnumMap<TextLanguage, String>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_JS_TS_LANGUAGE =
      new EnumMap<TextLanguage, String>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_SQL_LANGUAGE =
      new EnumMap<TextLanguage, String>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_HTML_LANGUAGE =
      new EnumMap<TextLanguage, String>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_LATEX_LANGUAGE =
      new EnumMap<TextLanguage, String>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_ABOUT_ME_TITLE =
      new EnumMap<TextLanguage, String>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_ABOUT_ME_CONTENT =
      new EnumMap<TextLanguage, String>(TextLanguage.class);

  static {
    TEXTMAP_SYLVAIN_JANET.put(TextLanguage.FRENCH, "Sylvain Janet");
    TEXTMAP_SYLVAIN_JANET.put(TextLanguage.ENGLISH, "Sylvain Janet");

    TEXTMAP_FRENCH_LANGUAGE_NAME.put(TextLanguage.FRENCH, "Français");
    TEXTMAP_FRENCH_LANGUAGE_NAME.put(TextLanguage.ENGLISH, "French");

    TEXTMAP_ENGLISH_LANGUAGE_NAME.put(TextLanguage.FRENCH, "Anglais");
    TEXTMAP_ENGLISH_LANGUAGE_NAME.put(TextLanguage.ENGLISH, "English");

    TEXTMAP_MAIN_TITLE.put(TextLanguage.FRENCH, "Je suis Sylvain Janet");
    TEXTMAP_MAIN_TITLE.put(TextLanguage.ENGLISH, "I am Sylvain Janet");

    TEXTMAP_OCCUPATION_TRAINER.put(TextLanguage.FRENCH, "Formateur");
    TEXTMAP_OCCUPATION_TRAINER.put(TextLanguage.ENGLISH, "Trainer");

    TEXTMAP_OCCUPATION_MATHEMATICIAN.put(TextLanguage.FRENCH,
        "Mathématicien");
    TEXTMAP_OCCUPATION_MATHEMATICIAN.put(TextLanguage.ENGLISH,
        "Mathematician");

    TEXTMAP_OCCUPATION_MUSICIAN.put(TextLanguage.FRENCH, "Musicien");
    TEXTMAP_OCCUPATION_MUSICIAN.put(TextLanguage.ENGLISH, "Musician");

    TEXTMAP_OCCUPATION_FULLSTACK_DEV.put(TextLanguage.FRENCH,
        "FullStack Developer");
    TEXTMAP_OCCUPATION_FULLSTACK_DEV.put(TextLanguage.ENGLISH,
        "Développeur fullstack");

    TEXTMAP_SKILLS_TITLE.put(TextLanguage.FRENCH, "Compétences");
    TEXTMAP_SKILLS_TITLE.put(TextLanguage.ENGLISH, "Skills");

    TEXTMAP_JAVA_LANGUAGE.put(TextLanguage.FRENCH, "Java");
    TEXTMAP_JAVA_LANGUAGE.put(TextLanguage.ENGLISH, "Java");

    TEXTMAP_CSHARP_LANGUAGE.put(TextLanguage.FRENCH, "C#");
    TEXTMAP_CSHARP_LANGUAGE.put(TextLanguage.ENGLISH, "C#");

    TEXTMAP_PYTHON_LANGUAGE.put(TextLanguage.FRENCH, "Python");
    TEXTMAP_PYTHON_LANGUAGE.put(TextLanguage.ENGLISH, "Python");

    TEXTMAP_JS_TS_LANGUAGE.put(TextLanguage.FRENCH,
        "Javascript / Typescript");
    TEXTMAP_JS_TS_LANGUAGE.put(TextLanguage.ENGLISH,
        "Javascript / Typescript");

    TEXTMAP_SQL_LANGUAGE.put(TextLanguage.FRENCH, "SQL");
    TEXTMAP_SQL_LANGUAGE.put(TextLanguage.ENGLISH, "SQL");

    TEXTMAP_HTML_LANGUAGE.put(TextLanguage.FRENCH, "HTML");
    TEXTMAP_HTML_LANGUAGE.put(TextLanguage.ENGLISH, "HTML");

    TEXTMAP_LATEX_LANGUAGE.put(TextLanguage.FRENCH, "LATEX");
    TEXTMAP_LATEX_LANGUAGE.put(TextLanguage.ENGLISH, "LATEX");

    TEXTMAP_ABOUT_ME_TITLE.put(TextLanguage.FRENCH, "A propos");
    TEXTMAP_ABOUT_ME_TITLE.put(TextLanguage.ENGLISH, "About me");

    TEXTMAP_ABOUT_ME_CONTENT.put(TextLanguage.FRENCH,
        "Développeur FullStack et formateur." + "[[1]]"
            + "Mon parcours professionnel a commencé par des études "
            + "en mathématiques : je suis normalien, agrégé de "
            + "mathématiques, et j'ai un master en logique et en "
            + "informatique théorique." + "[[2]]"
            + "J'ai entamé ma carrière dans le développement "
            + "informatique avec un titre professionnel Concepteur "
            + "développeur d'applications Java." + "[[3]]"
            + "J'ai participé au développement de plusieurs projets. "
            + "J'ai des compétences dans des frameworks back-end"
            + " comme Spring boot ou Entity Framework, et dans des "
            + "frameworks front-end comme Angular ou Vue.js. J'ai "
            + "également donné des formations en Python, Java, C#, "
            + "Javascript, SQL ou encore en Algorithmique." + "[[4]]"
            + "Enfin, j'ai plusieurs projets individuels, dont la "
            + "portée est plus large et reflète mes intérêts "
            + "personnels. De l'expression artistique avec la "
            + "musique, ma curiosité pour les langues, ma passion "
            + "pour les jeux." + "[[5]]"
            + "Pour plus d'informations, voir " + "[[6,mon cv]]");
    TEXTMAP_ABOUT_ME_CONTENT.put(TextLanguage.ENGLISH,
        "FullStack developer and trainer.[[1]]" + "[[1]]" + "blablabla"
            + "[[2]]" + "blablablablabla" + "[[3]]"
            + "blablablablablablablablabla" + "[[4]]"
            + "blablablablablablablablablablablabla" + "[[5]]"
            + "For more information, see " + "[[6,my cv]]");
  }

  /**
   * Initial text in db.
   */
  public static final List<LocalizedString> INIT_LOCALIZED_STRING =
      Collections.unmodifiableList(Arrays.asList(
          new LocalizedString(Arrays.asList("sylvain-janet"),
              TEXTMAP_SYLVAIN_JANET),
          new LocalizedString(Arrays.asList("french-language-name"),
              TEXTMAP_FRENCH_LANGUAGE_NAME),
          new LocalizedString(Arrays.asList("english-language-name"),
              TEXTMAP_FRENCH_LANGUAGE_NAME),
          new LocalizedString(Arrays.asList("main-title"),
              TEXTMAP_MAIN_TITLE),
          new LocalizedString(Arrays.asList("occupation-trainer"),
              TEXTMAP_OCCUPATION_TRAINER),
          new LocalizedString(Arrays.asList("occupation-mathematician"),
              TEXTMAP_OCCUPATION_MATHEMATICIAN),
          new LocalizedString(Arrays.asList("occupation-musician"),
              TEXTMAP_OCCUPATION_MUSICIAN),
          new LocalizedString(Arrays.asList("occupation-fullstack-dev"),
              TEXTMAP_OCCUPATION_FULLSTACK_DEV),
          new LocalizedString(Arrays.asList("skills-title"),
              TEXTMAP_SKILLS_TITLE),
          new LocalizedString(Arrays.asList("java-language"),
              TEXTMAP_JAVA_LANGUAGE),
          new LocalizedString(Arrays.asList("csharp-language"),
              TEXTMAP_CSHARP_LANGUAGE),
          new LocalizedString(Arrays.asList("python-language"),
              TEXTMAP_PYTHON_LANGUAGE),
          new LocalizedString(Arrays.asList("js-ts-language"),
              TEXTMAP_JS_TS_LANGUAGE),
          new LocalizedString(Arrays.asList("sql-language"),
              TEXTMAP_SQL_LANGUAGE),
          new LocalizedString(Arrays.asList("html-language"),
              TEXTMAP_HTML_LANGUAGE),
          new LocalizedString(Arrays.asList("latex-language"),
              TEXTMAP_LATEX_LANGUAGE),
          new LocalizedString(Arrays.asList("about-me-title"),
              TEXTMAP_ABOUT_ME_TITLE),
          new LocalizedString(Arrays.asList("about-me-content"),
              TEXTMAP_ABOUT_ME_CONTENT)));

  private InitialData() {

  }
}
