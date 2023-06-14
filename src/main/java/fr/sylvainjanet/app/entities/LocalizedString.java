package fr.sylvainjanet.app.entities;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import fr.sylvainjanet.app.config.ConfigurationParams;
import fr.sylvainjanet.app.config.EntitiesParams;

/**
 * Localized string.
 * 
 * @author Sylvain
 *
 */
@Entity(name = EntitiesParams.LOCALIZED_STRING_NAME)
@Table(name = EntitiesParams.LOCALIZED_STRING_NAME)
public class LocalizedString {

  /**
   * The id.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * List of selectors where this message is used. This could correspond to
   * a css class, an html id, or any other string. This way, the same
   * message can be consistently used at different places.
   * https://www.baeldung.com/java-jpa-persist-string-list
   * https://www.baeldung.com/hibernate-initialize-proxy-exception
   */
  @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
  @CollectionTable(name = EntitiesParams.LOCALIZED_STRING_SELECTORS_NAME,
      joinColumns = @JoinColumn(
          name = EntitiesParams.LOCALIZED_STRING_NAME + "_id"),
      uniqueConstraints = { @UniqueConstraint(columnNames = {
          EntitiesParams.LOCALIZED_STRING_SELECTOR_NAME }) })
  @Column(name = EntitiesParams.LOCALIZED_STRING_SELECTOR_NAME,
      nullable = false, length = ConfigurationParams.MAX_STR_SIZE,
      unique = true)
  private List<String> selectors;

  /**
   * Map containing all the messages corresponding to every language.
   * https://www.baeldung.com/jpa-persisting-enums-in-jpa
   */
  @ElementCollection(fetch = FetchType.LAZY)
  @CollectionTable(name = EntitiesParams.LOCALIZED_STRING_TEXTMAP_NAME,
      foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,
          name = EntitiesParams.LOCALIZED_STRING_NAME),
      joinColumns = @JoinColumn(
          name = EntitiesParams.LOCALIZED_STRING_NAME + "_id"))
  @MapKeyColumn(name = EntitiesParams.LOCALIZED_STRING_LANGUAGE_NAME,
      length = ConfigurationParams.MAX_STR_SIZE, nullable = false)
  @MapKeyEnumerated(EnumType.STRING)
  @Column(name = EntitiesParams.LOCALIZED_STRING_TEXT_NAME,
      length = ConfigurationParams.MAX_LONG_STR_SIZE, nullable = false)
  private Map<TextLanguage, String> textMap =
      new EnumMap<>(TextLanguage.class);

  /**
   * Is this localized string defined for all languages ? The textMap
   * should have values for every TextLanguage.
   * 
   * @return Whether or not this localized string defined for all
   *         languages.
   */
  public boolean isDefinedForAllLanguages() {
    for (TextLanguage language : TextLanguage.values()) {
      if (!this.isDefinedFor(language)) {
        return false;
      }
    }
    return true;
  }

  /**
   * Is this localized string defined for a language ? The textMap should
   * have a value for this language.
   * 
   * @param language the language to look at
   * @return Whether or not this localized string defined for a language
   */
  public boolean isDefinedFor(final TextLanguage language) {
    return textMap.keySet().contains(language);
  }

  /**
   * Is this localized string defined and a non null non empty string for
   * all languages ? The textMap should have values for every TextLanguage.
   * 
   * @return Whether or not this localized string defined and a non null
   *         non empty string for all languages.
   */
  public boolean isNonEmptyForAllLanguages() {
    for (TextLanguage language : TextLanguage.values()) {
      if (!this.isNonEmptyFor(language)) {
        return false;
      }
    }
    return true;

  }

  /**
   * Is this localized string defined and a non null non empty string for a
   * language ? The textMap should have a value for this language.
   * 
   * @param language the language to look at
   * @return Whether or not this localized string defined and a non null
   *         non empty string for a language
   */
  public boolean isNonEmptyFor(final TextLanguage language) {
    return textMap.keySet().contains(language)
        && textMap.get(language) != null
        && !textMap.get(language).isEmpty();
  }

  /**
   * Is this localized string used for a selector ? The list of selectors
   * should contain the selector.
   * 
   * @param selector the selector to test
   * @return whether or not his localized string used for the selector.
   */
  public boolean isForSelector(final String selector) {
    return selectors.contains(selector);
  }

  /**
   * Add a selector to this localized string.
   * 
   * @param selector the selector
   */
  public void addSelector(final String selector) {
    selectors.add(selector);
  }

  /**
   * Remove a selector from this localized string.
   * 
   * @param selector the selector
   */
  public void removeSelector(final String selector) {
    selectors.remove(selector);
  }

  /**
   * Get the text content for a specific language.
   * 
   * @param language the language
   * @return the text content in that specific language
   */
  public String from(final TextLanguage language) {
    return textMap.get(language);
  }

  /**
   * Translates this string in a specific language.
   * 
   * @param language the language
   * @param text     the text content in that specific language
   */
  public void translateIn(final TextLanguage language, final String text) {
    textMap.put(language, text);
  }

  /**
   * Default constructor.
   */
  public LocalizedString() {
    super();
  }

  /**
   * Full constructor.
   * 
   * @param id        the id
   * @param selectors the selectors
   * @param textMap   the textMap
   */
  public LocalizedString(final Long id, final List<String> selectors,
      final Map<TextLanguage, String> textMap) {
    super();
    this.id = id;
    this.selectors = selectors;
    this.textMap = textMap;
  }

  /**
   * Constructor without the id.
   * 
   * @param selectors the selectors
   * @param textMap   the textMap
   */
  public LocalizedString(final List<String> selectors,
      final Map<TextLanguage, String> textMap) {
    super();
    this.selectors = selectors;
    this.textMap = textMap;
  }

  /**
   * Hashcode based on id.
   */
  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  /**
   * Equals based on id.
   */
  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LocalizedString other = (LocalizedString) obj;
    return Objects.equals(id, other.id);
  }

  /**
   * To String method.
   */
  @Override
  public String toString() {
    return "LocalizedString [id=" + id + ", selectors=" + selectors
        + ", textMap=" + textMap + "]";
  }

}
