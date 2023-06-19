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
      new EnumMap<>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_FRENCH_LANGUAGE_NAME =
      new EnumMap<>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_ENGLISH_LANGUAGE_NAME =
      new EnumMap<>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_MAIN_TITLE =
      new EnumMap<>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_OCCUPATION_TRAINER =
      new EnumMap<>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  // CHECKSTYLE.OFF: LineLength - this line can't be made shorter
  private static final Map<TextLanguage, String> TEXTMAP_OCCUPATION_MATHEMATICIAN =
      new EnumMap<>(TextLanguage.class);
  // CHECKSTYLE.ON: LineLength
  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_OCCUPATION_MUSICIAN =
      new EnumMap<>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  // CHECKSTYLE.OFF: LineLength - this line can't be made shorter
  private static final Map<TextLanguage, String> TEXTMAP_OCCUPATION_FULLSTACK_DEV =
      new EnumMap<>(TextLanguage.class);
  // CHECKSTYLE.ON: LineLength

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_INFO_NAME_FIELD =
      new EnumMap<>(TextLanguage.class);
  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_INFO_PROFILE_FIELD =
      new EnumMap<>(TextLanguage.class);
  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_INFO_EMAIL_FIELD =
      new EnumMap<>(TextLanguage.class);
  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_INFO_PHONE_FIELD =
      new EnumMap<>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_SKILLS_TITLE =
      new EnumMap<>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_JAVA_LANGUAGE =
      new EnumMap<>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_CSHARP_LANGUAGE =
      new EnumMap<>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_PYTHON_LANGUAGE =
      new EnumMap<>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_JS_TS_LANGUAGE =
      new EnumMap<>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_SQL_LANGUAGE =
      new EnumMap<>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_HTML_LANGUAGE =
      new EnumMap<>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_LATEX_LANGUAGE =
      new EnumMap<>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_ABOUT_ME_TITLE =
      new EnumMap<>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_ABOUT_ME_CONTENT =
      new EnumMap<>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_WEBSITE =
      new EnumMap<>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_CV_FILENAME =
      new EnumMap<>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_BACKTOTOP_ALT =
      new EnumMap<>(TextLanguage.class);

  /**
   * Texts for sylvain janet.
   */
  private static final Map<TextLanguage, String> TEXTMAP_CVIMG_ALT =
      new EnumMap<>(TextLanguage.class);

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
        "Développeur fullstack");
    TEXTMAP_OCCUPATION_FULLSTACK_DEV.put(TextLanguage.ENGLISH,
        "FullStack Developer");

    TEXTMAP_INFO_NAME_FIELD.put(TextLanguage.FRENCH, "Nom");
    TEXTMAP_INFO_NAME_FIELD.put(TextLanguage.ENGLISH, "Name");

    TEXTMAP_INFO_PROFILE_FIELD.put(TextLanguage.FRENCH, "Profil");
    TEXTMAP_INFO_PROFILE_FIELD.put(TextLanguage.ENGLISH, "Profile");

    TEXTMAP_INFO_EMAIL_FIELD.put(TextLanguage.FRENCH, "Email");
    TEXTMAP_INFO_EMAIL_FIELD.put(TextLanguage.ENGLISH, "Email");

    TEXTMAP_INFO_PHONE_FIELD.put(TextLanguage.FRENCH, "Téléphone");
    TEXTMAP_INFO_PHONE_FIELD.put(TextLanguage.ENGLISH, "Phone");

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
        "Développeur FullStack et Formateur." + "[[]]"
            + "Mon parcours professionnel a commencé par des études "
            + "en mathématiques : je suis normalien, agrégé de "
            + "mathématiques, et j'ai un master en logique et en "
            + "informatique théorique." + "[[]]"
            + "J'ai entamé ma carrière dans le développement "
            + "informatique avec un titre professionnel Concepteur "
            + "développeur d'applications Java." + "[[]]"
            + "J'ai participé au développement de plusieurs projets. "
            + "J'ai des compétences dans des frameworks back-end"
            + " comme [[1,Spring boot]] ou [[2,Entity Framework]], et dans des "
            + "frameworks front-end comme [[3,Angular]]. J'ai "
            + "également donné des formations en [[4,Python]], [[5,Java]], "
            + "[[6,C#]], [[7,Javascript]], [[8,SQL]] ou encore en "
            + "[[9,Algorithmique]]." + "[[]]"
            + "Enfin, j'ai plusieurs projets individuels, dont la "
            + "portée est plus large et reflète mes intérêts "
            + "personnels. De l'expression artistique avec la "
            + "musique, ma curiosité pour les langues, ma passion "
            + "pour les jeux." + "[[]]" + "Pour plus d'informations, voir "
            + "[[a_asset,mon cv]].");
    TEXTMAP_ABOUT_ME_CONTENT.put(TextLanguage.ENGLISH,
        "FullStack developer and Trainer." + "[[]]"
            + "My professional journey began with studies in mathematics: "
            + "I am a graduate of the École Normale Supérieure, an associate "
            + "professor of mathematics, and I hold a master's degree in logic "
            + "and theoretical computer science." + "[[]]"
            + "I started my career in software development with a professional "
            + "title as a Java application developer." + "[[]]"
            + "I have been involved in the development of several projects. "
            + "I have skills in back-end frameworks like [[1,Spring Boot]] and "
            + "[[2,Entity Framework]], as well as front-end frameworks like "
            + "[[3,Angular]]. I have also provided training in [[4,Python]], "
            + "[[5,Java]], [[6,C#]], [[7,JavaScript]], [[8,SQL]], and "
            + "[[9,Algorithmics]]." + "[[]]"
            + "Furthermore, I have several individual projects that have a "
            + "broader scope and reflect my personal interests, such as "
            + "artistic expression through music, my curiosity for languages, "
            + "and my passion for games." + "[[]]"
            + "For more information, please refer to [[a_asset,my CV]].");

    TEXTMAP_WEBSITE.put(TextLanguage.FRENCH, "sylvainjanet.fr");
    TEXTMAP_WEBSITE.put(TextLanguage.ENGLISH, "sylvainjanet.com");

    TEXTMAP_CV_FILENAME.put(TextLanguage.FRENCH, "JanetSylvain_CV_FR.pdf");
    TEXTMAP_CV_FILENAME.put(TextLanguage.ENGLISH,
        "JanetSylvain_CV_EN.pdf");

    TEXTMAP_BACKTOTOP_ALT.put(TextLanguage.FRENCH,
        "Icône de retour en haut de page");
    TEXTMAP_BACKTOTOP_ALT.put(TextLanguage.ENGLISH, "Back to top icon");

    TEXTMAP_CVIMG_ALT.put(TextLanguage.FRENCH,
        "Photo de CV de Sylvain Janet");
    TEXTMAP_CVIMG_ALT.put(TextLanguage.ENGLISH,
        "CV photo of Sylvain Janet");
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
              TEXTMAP_ENGLISH_LANGUAGE_NAME),
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
          new LocalizedString(Arrays.asList("about-name-field"),
              TEXTMAP_INFO_NAME_FIELD),
          new LocalizedString(Arrays.asList("about-profile-field"),
              TEXTMAP_INFO_PROFILE_FIELD),
          new LocalizedString(Arrays.asList("about-email-field"),
              TEXTMAP_INFO_EMAIL_FIELD),
          new LocalizedString(Arrays.asList("about-phone-field"),
              TEXTMAP_INFO_PHONE_FIELD),
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
              TEXTMAP_ABOUT_ME_CONTENT),
          new LocalizedString(Arrays.asList("website"), TEXTMAP_WEBSITE),
          new LocalizedString(Arrays.asList("cv-file-name"),
              TEXTMAP_CV_FILENAME),
          new LocalizedString(Arrays.asList("back-to-top-alt"),
              TEXTMAP_BACKTOTOP_ALT),
          new LocalizedString(Arrays.asList("cv-img-alt"),
              TEXTMAP_CVIMG_ALT)));

  private InitialData() {

  }
}
